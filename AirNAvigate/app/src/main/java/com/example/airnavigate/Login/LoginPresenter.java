package com.example.airnavigate.Login;

/**
 * Created by Kelebro63 on 29.11.2015.
 */
public interface LoginPresenter {
    public void ValidateCredentials(String username, String password);
    public void populateAutoComplete();
    public void attemptLogin();
}
