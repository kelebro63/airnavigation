package com.example.airnavigate.Modules;

import com.example.airnavigate.Views.Login.ActivityScope;
import com.example.airnavigate.Views.Login.LoginActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Bistrov Alexey on 10.12.2015.
 */
@Module
public class LoginActivityModule {
    private LoginActivity loginActivity;

    public LoginActivityModule(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

//    @Provides
//    @ActivityScope
//    LoginPresenterImpl loginPresenter(LoginActivity loginActivity) {
//        return new LoginPresenterImpl(loginActivity);
//    }

    @Provides
    @ActivityScope
    LoginActivity provideLoginActivity() {
        return loginActivity;
    }

//    @Provides
//    public LoginInteractorImpl provideInteractor(LoginInteractorImpl interactor) {
//        return interactor;
//    }




}
