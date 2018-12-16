package com.almawashi.base.utils.widgets.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;

import java.lang.ref.WeakReference;



public class CustomProgressDialog {
    private WeakReference<Activity> context;
    private ProgressDialog dialog;
    private Dialog dialog2;

    public CustomProgressDialog(Activity context) {
        this.context = new WeakReference<>(context);

/*
        dialog = new ProgressDialog(context);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        dialog.setOnShowListener(dialogInterface -> {
        });
        dialog.setOnDismissListener(dialogInterface -> {
        });*/
    }

    public void show() {
        /*if (dialog2 == null) {
            dialog2 = Utils.showFullScreenDialog(context.get(), dialog1 -> {
                View view = LayoutInflater.from(context.get())
                        .inflate(R.layout.view_progress, null);

                dialog1.setContentView(view);
            });
        } else if (dialog2 != null) dialog2.show();*/
    }

    public void dismiss() {
        if (dialog2 != null) dialog2.dismiss();
    }
}
