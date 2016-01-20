package com.example.airnavigate.Components;

import android.content.Context;

import com.example.airnavigate.Data.IDataSource;
import com.example.airnavigate.Internal.BackgroundThread;
import com.example.airnavigate.Internal.MainThread;
import com.example.airnavigate.Modules.AppModule;
import com.example.airnavigate.Modules.LoginActivityModule;
import com.example.airnavigate.Modules.MainActivityFragmentModule;
import com.example.airnavigate.Modules.MainActivityModule;
import com.example.airnavigate.Utils.Prefs;

import javax.inject.Singleton;

import dagger.Component;
import rx.Scheduler;

/**
 * Created by Bistrov Alexey on 10.12.2015.
 */
@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {
    LoginActivityComponent initLoginActivityComponent(LoginActivityModule module);
    MainActivityComponent initMainActivityComponent(MainActivityModule module);
    MainActivityFragmentsComponent initMainActivityFragmentComponent(MainActivityFragmentModule module);

    @MainThread
    Scheduler main();

    @BackgroundThread
    Scheduler background();

    IDataSource provideDataSource();

    Context context();

    Prefs prefs();

}
