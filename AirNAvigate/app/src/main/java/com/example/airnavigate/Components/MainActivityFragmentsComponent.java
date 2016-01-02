package com.example.airnavigate.Components;

import com.example.airnavigate.Modules.MainActivityFragmentModule;
import com.example.airnavigate.Views.Main.ThematicBloks.MainListFragment;

import dagger.Subcomponent;

/**
 * Created by Kelebro63 on 02.01.2016.
 */
@Subcomponent(
        modules = MainActivityFragmentModule.class
)
public interface MainActivityFragmentsComponent {

        void inject(MainListFragment newsListFragment);




}
