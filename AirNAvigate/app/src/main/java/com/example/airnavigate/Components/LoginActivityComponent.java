package com.example.airnavigate.Components;

import com.example.airnavigate.Modules.LoginActivityModule;
import com.example.airnavigate.Views.Login.ActivityScope;
import com.example.airnavigate.Views.Login.LoginActivity;

import dagger.Subcomponent;

/**
 * Created by Bistrov Alexey on 10.12.2015.
 */

@ActivityScope
@Subcomponent(
        modules = LoginActivityModule.class
)
public interface LoginActivityComponent {
    LoginActivity inject(LoginActivity loginActivity);
}
