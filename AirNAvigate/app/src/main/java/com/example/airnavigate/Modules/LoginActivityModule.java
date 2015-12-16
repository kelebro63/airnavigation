package com.example.airnavigate.Modules;

import com.example.airnavigate.Views.Login.ActivityScope;
import com.example.airnavigate.Views.Login.LoginActivity;
import com.example.airnavigate.Views.Login.LoginPresenterImpl;
import com.example.airnavigate.Views.Login.LoginView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bistrov Alexey on 10.12.2015.
 */
@Module
public class LoginActivityModule {
    private LoginActivity loginActivity;
    private final LoginView loginView;

    public LoginActivityModule(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
        this.loginView = loginActivity;
    }

    @Provides
    @ActivityScope
    LoginPresenterImpl loginPresenter(LoginActivity loginActivity) {
        return new LoginPresenterImpl(loginView, loginActivity);
    }

    @Provides
    @ActivityScope
    LoginActivity provideLoginActivity() {
        return loginActivity;
    }




}
