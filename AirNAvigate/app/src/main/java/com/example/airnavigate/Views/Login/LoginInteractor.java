package com.example.airnavigate.Views.Login;

/**
 * Created by Kelebro63 on 29.11.2015.
 */
public interface LoginInteractor {
    public void validate(String email, String password, OnValidateLoginFinishedListener listener);
    public void login(String email, String password, OnLoginFinishedListener listener);
}
