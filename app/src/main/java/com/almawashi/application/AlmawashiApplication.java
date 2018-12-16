package com.almawashi.application;

import android.content.Context;
import android.content.res.Configuration;
import android.os.StrictMode;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatDelegate;

import com.almawashi.BuildConfig;
import com.almawashi.base.di.Injector;
import com.almawashi.base.mvp.base.BaseApplication;
import com.almawashi.base.utils.ReleaseTree;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import timber.log.Timber;

public class AlmawashiApplication extends BaseApplication {

    private static Realm localDataSource;

    @Override
    public void onCreate() {
        super.onCreate();

        ///*Create Local Database Instance.
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("mydb")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        localDataSource = Realm.getInstance(realmConfiguration);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

//        Fabric.with(this, new Crashlytics(), new Answers());


        /*new FlurryAgent.Builder()
                .withLogEnabled(true)
                .withCaptureUncaughtExceptions(true)
                .withContinueSessionMillis(10)
                .withLogEnabled(true)
                .withLogLevel(VERBOSE)
                .build(this, getString(R.string.FLURRY_API_KEY));*/

        if (BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree() {
                @Override
                public void log(int priority, String tag, String message, Throwable t) {
                    Logger.log(priority, tag, message, t);
                }
            });
        else Timber.plant(new ReleaseTree());

        initializeApplicationComponent();

        /*CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/din-next-regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build());*/

        

        if (BuildConfig.DEBUG) {
            if (enableLeakCanary()) return;
            enabledStrictMode();
        }
    }

    ///*getLocalDatabase
    public static Realm getLocalDatabase() {
        return localDataSource;
    }

    private boolean enableLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return true;
        }
        LeakCanary.install(this);
        return false;
    }

    private void enabledStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyDeath()
                .build());

        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .penaltyDeath()
                .build());
    }

    private void initializeApplicationComponent() {
        if (Injector.INSTANCE.getAppComponent() == null) {
            Injector.INSTANCE.initializeAppComponent(this);
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        super.attachBaseContext(LocaleHelper.onAttach(base));
        MultiDex.install(this);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        LocaleHelper.onAttach(this);
    }
}
