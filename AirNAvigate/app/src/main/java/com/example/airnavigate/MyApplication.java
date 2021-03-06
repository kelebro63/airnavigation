package com.example.airnavigate;

import android.app.Application;
import android.content.Context;

import com.example.airnavigate.Components.AppComponent;
import com.example.airnavigate.Components.DaggerAppComponent;
import com.example.airnavigate.Modules.AppModule;

/**
 * Created by Kelebro63 on 29.11.2015.
 */
public class MyApplication extends Application {
    private static MyApplication instance;
    private AppComponent appComponent;

    public MyApplication() {
        instance = this;
    }

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
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

    public AppComponent getAppComponent() {
        return appComponent;
    }

}
