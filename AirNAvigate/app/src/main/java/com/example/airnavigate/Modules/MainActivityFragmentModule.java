package com.example.airnavigate.Modules;

import com.example.airnavigate.Views.Main.MainActivity;

import dagger.Module;

/**
 * Created by Kelebro63 on 02.01.2016.
 */
@Module
public class MainActivityFragmentModule {

    private MainActivity mainActivity;

    public MainActivityFragmentModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }


}
