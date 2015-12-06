package com.example.airnavigate.Views.Login;

import java.util.List;

/**
 * Created by Kelebro63 on 29.11.2015.
 */
public interface LoginView {

    public void showProgress();

    public void hideProgress();

    public void setEmailError();

    public void setPasswordError();

    public void startMainScreen();

    public void loadFinished(List<String> emailAddressCollection);

}
