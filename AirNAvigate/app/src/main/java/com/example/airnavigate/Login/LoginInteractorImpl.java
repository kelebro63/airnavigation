package com.example.airnavigate.Login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Kelebro63 on 29.11.2015.
 */
public class LoginInteractorImpl implements LoginInteractor{
    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                }
                if (!error){
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
