package com.example.airnavigate.Data;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Kelebro63 on 04.01.2016.
 */
public class Credentials {

    private String login;
    private String password;
    private String token;


    @Inject
    @Singleton
    public Credentials() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
