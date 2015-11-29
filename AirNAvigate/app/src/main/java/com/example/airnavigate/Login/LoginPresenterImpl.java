package com.example.airnavigate.Login;

/**
 * Created by Kelebro63 on 29.11.2015.
 */
public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener{

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void ValidateCredentials(String username, String password) {
        this.loginView.showProgress();
        loginInteractor.login(username, password, this);
    }

    @Override
    public void onUsernameError() {
        loginView.setUsernameError();
        loginView.hideProgress();
    }

    @Override
    public void onPasswordError() {
        loginView.setPasswordError();
        loginView.hideProgress();
    }

    @Override
    public void onSuccess() {
        loginView.startMainScreen();
    }
}
