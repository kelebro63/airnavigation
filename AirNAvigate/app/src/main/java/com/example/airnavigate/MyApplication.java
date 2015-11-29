package com.example.airnavigate;

import android.app.Application;
import android.content.Context;

/**
 * Created by Kelebro63 on 29.11.2015.
 */
public class MyApplication extends Application {
    private static MyApplication instance;

    public MyApplication() {
        instance = this;
    }

    public static Context getContext() {
        return instance;
    }
}
