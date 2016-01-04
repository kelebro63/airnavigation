package com.example.airnavigate.Components;

import com.example.airnavigate.Modules.MainActivityFragmentModule;
import com.example.airnavigate.Views.Main.Deputies.MainListDeputiesFragment;
import com.example.airnavigate.Views.Main.ThematicBloks.MainListTopicsFragment;

import dagger.Subcomponent;

/**
 * Created by Kelebro63 on 02.01.2016.
 */
@Subcomponent(
        modules = MainActivityFragmentModule.class
)
public interface MainActivityFragmentsComponent {

        void inject(MainListTopicsFragment newsListFragment);

        void inject(MainListDeputiesFragment mainListDeputiesFragment);


}
