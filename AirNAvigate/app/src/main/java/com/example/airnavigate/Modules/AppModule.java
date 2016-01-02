package com.example.airnavigate.Modules;

import android.app.Application;
import android.content.Context;

import com.example.airnavigate.Data.DataSourceImpl;
import com.example.airnavigate.Data.IDataSource;
import com.example.airnavigate.Internal.BackgroundThread;
import com.example.airnavigate.Internal.MainThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Kelebro63 on 10.12.2015.
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    @MainThread
    Scheduler provideMainThreadScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    @BackgroundThread
    Scheduler provideBackgroundThreadScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Singleton
    IDataSource provideDataSource() {
        return new DataSourceImpl();
    }

    @Provides
    @Singleton
    Context provideContext() {
        return application;
    }
}
