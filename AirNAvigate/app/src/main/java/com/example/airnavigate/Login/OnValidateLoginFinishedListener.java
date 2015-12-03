package com.example.airnavigate.Login;

/**
 * Created by Kelebro63 on 29.11.2015.
 */
public interface OnValidateLoginFinishedListener {

    public void onUsernameError();

    public void onPasswordError();

    public void onSuccess(String username, String password);

}
