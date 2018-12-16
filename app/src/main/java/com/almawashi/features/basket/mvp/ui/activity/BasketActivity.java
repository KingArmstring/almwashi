package com.almawashi.features.basket.mvp.ui.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.almawashi.R;
import com.almawashi.base.di.component.ApplicationComponent;
import com.almawashi.base.mvp.base.BaseActivity;
import com.almawashi.base.mvp.model.entity.Cutting;
import com.almawashi.base.mvp.model.entity.Item;
import com.almawashi.base.mvp.model.entity.ItemDetails;
import com.almawashi.base.mvp.model.entity.Quantity;
import com.almawashi.base.mvp.model.local.LocalDataSourceRealm;
import com.almawashi.features.basket.di.component.DaggerBasketComponent;
import com.almawashi.features.basket.di.module.BasketModule;
import com.almawashi.features.basket.mvp.contract.BasketContract;
import com.almawashi.features.basket.mvp.presenter.BasketPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.realm.RealmResults;

public class BasketActivity extends BaseActivity<BasketPresenter> implements BasketContract.View {

//    private static final String PARAM_CATEGORY_ID = "PARAM_CATEGORY_ID";
//    private static final String PARAM_CATEGORY_NAME = "PARAM_CATEGORY_NAME";
    private static Item data;
    private int cuttingNumber = -1;
    private int quantityNumber = -1;
    private LocalDataSourceRealm localDataSourceRealm;
    private List<Quantity> quantities;
    private List<Cutting> cuttings;
    private AlertDialog dialog;

    @BindView(R.id.et_delivery_date)
    TextInputEditText etDeliveryDate;//should be calendar
    @BindView(R.id.et_delivery_location)
    TextInputEditText etDeliveryLocation;
    @BindView(R.id.spinner_quantity)
    Spinner spQuantity;
    @BindView(R.id.spinner_cutting)
    Spinner spCutting;
    @BindView(R.id.currentStockId)
    TextView txtCurrentStock;
    @BindView(R.id.txtAnimalName)
    TextView txtAnimalName;
    @BindView(R.id.txtWeight)
    TextView txtWeight;
    @BindView(R.id.txtPrice)
    TextView txtPrice;
    @BindView(R.id.txtFinalPrice)
    TextView txtFinalPrice;
    @BindView(R.id.imgAnimal)
    AppCompatImageView imgAnimal;



    public static void start(Context context, Item item) {
        Intent intent = new Intent(context, BasketActivity.class);
        data = item;
        context.startActivity(intent);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_basket;
    }

    @Override
    public void onViewReady(Bundle savedInstanceState, Intent intent) {
        getPresenter().bringPurchaseData(data.getId());

        localDataSourceRealm = new LocalDataSourceRealm();

        etDeliveryDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(BasketActivity.this);
                View calendarViewLayout = getLayoutInflater().inflate(R.layout.date_dialog_layout, null);
                CalendarView calendar = (CalendarView) calendarViewLayout.findViewById(R.id.calendarId);
                calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                        String date = dayOfMonth + "/ " + month + "/ " + year;
                        etDeliveryDate.setText(date);
                        dialog.dismiss();
                    }
                });
                builder.setView(calendarViewLayout);
                dialog = builder.create();
                dialog.show();
            }
        });

        spQuantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                quantityNumber = quantities.get(i).getId();
                /*I know I should add the cutting to equation but I can't
                final the price per cut in the Item instance.
                */
                int finalPrice = data.getPrice() * quantityNumber;
                txtFinalPrice.setText(String.valueOf(finalPrice));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spCutting.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cuttingNumber = cuttings.get(i).getId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        txtCurrentStock.setText(String.valueOf(data.getCurrentStock()));
        txtAnimalName.setText(data.getNameEN());
        txtWeight.setText(data.getWeight());
        txtPrice.setText(String.valueOf(data.getPrice()));

        Picasso.with(this).load(data.getPictureURL()).into(imgAnimal);
    }

    @Override
    protected void resolveDaggerDependency(ApplicationComponent appComponent) {
        DaggerBasketComponent
                .builder()
                .applicationComponent(appComponent)
                .basketModule(new BasketModule(this))
                .build()
                .inject(this);
    }

    @OnClick(R.id.btnAddToBasket)
    public void onViewClicked(View view) {
        ///* adding the instance to the database.
        localDataSourceRealm.getLocalDataSource().beginTransaction();
        ItemDetails itemToBeStored = localDataSourceRealm.getLocalDataSource().createObject(ItemDetails.class);

        itemToBeStored.setItemId(data.getId());
        itemToBeStored.setItemName(data.getNameEN());
        itemToBeStored.setCurrentStock(data.getCurrentStock());
        itemToBeStored.setDescription(data.getDescriptionEN());
        itemToBeStored.setWeight(data.getWeight());
        itemToBeStored.setPrice(data.getPrice());
        itemToBeStored.setImgUrl(data.getPictureURL());
        itemToBeStored.setQuantityNum(quantityNumber);
        itemToBeStored.setCuttingNum(cuttingNumber);

        localDataSourceRealm.getLocalDataSource().commitTransaction();
        RealmResults<ItemDetails> items = localDataSourceRealm.getLocalDataSource().where(ItemDetails.class).findAll();
        Toast.makeText(this, "size: " + String.valueOf(items.size()), Toast.LENGTH_SHORT).show();
    }


    @Override
    public void updateQuantitySpinner(List<Quantity> quantities) {
        ArrayList<String> spQuantityList = new ArrayList<>();
        this.quantities = quantities;
        for (int i = 0; i < quantities.size(); i++) {
            spQuantityList.add(String.valueOf(quantities.get(i).getId()));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, spQuantityList);
        spQuantity.setAdapter(adapter);
    }

    @Override
    public void updateCuttingSpinner(List<Cutting> cuttings) {
        ArrayList<String> spCuttingList = new ArrayList<>();
        this.cuttings = cuttings;
        for (int i = 0; i < cuttings.size(); i++) {
            spCuttingList.add(String.valueOf(cuttings.get(i).getId()));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, spCuttingList);
        spCutting.setAdapter(adapter);
    }
}
