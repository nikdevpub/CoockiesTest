package com.niknightarts.coockiestest;
import android.app.Application;
import com.niknightarts.coockiestest.di.AppComponent;
import com.niknightarts.coockiestest.di.DaggerAppComponent;
import com.niknightarts.coockiestest.di.module.ContextModule;

import timber.log.Timber;

public class App extends Application {
    private static App instance;
    private static AppComponent appComponent;

    public static AppComponent appComponent() {
        if (appComponent == null) {
            throw new IllegalStateException("AppComponent should be initialized!");
        }
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initAppComponent();

        if (BuildConfig.DEBUG) Timber.plant(new Timber.DebugTree());

    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .contextModule(new ContextModule(instance))
                .build();
    }
}
