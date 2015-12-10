package com.example.airnavigate;

import android.app.Application;
import android.content.Context;

import com.example.airnavigate.Components.AppComponent;

/**
 * Created by Kelebro63 on 29.11.2015.
 */
public class MyApplication extends Application {
    private static MyApplication instance;
    private AppComponent appComponent;

    public MyApplication() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initAppComponent();
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static Context getContext() {
        return instance;
    }

}
