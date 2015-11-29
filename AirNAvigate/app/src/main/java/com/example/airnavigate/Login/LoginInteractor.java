package com.example.airnavigate.Login;

/**
 * Created by Kelebro63 on 29.11.2015.
 */
public interface LoginInteractor {
    public void login(String username, String password, OnLoginFinishedListener listener);
}
