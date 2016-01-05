package com.example.airnavigate.Modules;

import com.example.airnavigate.Views.Base.BaseActivity;
import com.example.airnavigate.Views.Base.BaseFragment;
import com.example.airnavigate.Views.Main.FragmentDispatcher;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kelebro63 on 02.01.2016.
 */
@Module
public class MainActivityFragmentModule {

    private BaseFragment fragment;
    private BaseActivity activity;

    public MainActivityFragmentModule(BaseFragment fragment) {
        this.fragment = fragment;
        activity = provideActivity();
    }

    @Provides
    BaseActivity provideActivity() {
        return (BaseActivity) fragment.getActivity();
    }

    @Provides
    FragmentDispatcher getFragmentDispatcher() {
        return new FragmentDispatcher(activity.getSupportFragmentManager(), activity.getResources(), activity);
    }
}
