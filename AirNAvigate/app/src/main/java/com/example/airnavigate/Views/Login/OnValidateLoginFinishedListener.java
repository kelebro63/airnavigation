package com.example.airnavigate.Views.Login;

/**
 * Created by Kelebro63 on 29.11.2015.
 */
public interface OnValidateLoginFinishedListener {

    public void onEmailError();

    public void onPasswordError();

    public void onSuccessValidate(String username, String password);

}
