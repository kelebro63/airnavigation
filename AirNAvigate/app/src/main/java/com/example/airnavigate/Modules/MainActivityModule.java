package com.example.airnavigate.Modules;

import com.example.airnavigate.Views.Login.ActivityScope;
import com.example.airnavigate.Views.Main.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bistrov Alexey on 10.12.2015.
 */
@Module
public class MainActivityModule {
    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity() {
        return mainActivity;
    }




}
