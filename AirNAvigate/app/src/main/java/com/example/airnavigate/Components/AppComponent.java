package com.example.airnavigate.Components;

import com.example.airnavigate.Modules.AppModule;
import com.example.airnavigate.Modules.LoginActivityModule;

import javax.inject.Singleton;

import dagger.Component;

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
}
