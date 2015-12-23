package com.example.airnavigate.Components;

import com.example.airnavigate.Modules.MainActivityModule;
import com.example.airnavigate.Views.Login.ActivityScope;
import com.example.airnavigate.Views.Main.MainActivity;

import dagger.Subcomponent;

/**
 * Created by Bistrov Alexey on 10.12.2015.
 */

@ActivityScope
@Subcomponent(
        modules = MainActivityModule.class
)
public interface MainActivityComponent {
    MainActivity inject(MainActivity mainActivity);
}
