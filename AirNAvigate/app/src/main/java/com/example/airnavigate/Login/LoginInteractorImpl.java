package com.example.airnavigate.Login;

import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by Kelebro63 on 29.11.2015.
 */
public class LoginInteractorImpl implements LoginInteractor{

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };

    private UserLoginTask mAuthTask = null;
    private OnLoginFinishedListener loginListener = null;

    @Override
    public void validate(final String email, final String password, final OnValidateLoginFinishedListener listener) {

        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(email)){
                    listener.onUsernameError();
                    error = true;
                }
                if (TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                }
                if (!error){
                    listener.onSuccess(email, password);
                }
            }
        }, 2000);
    }

    @Override
    public void login(String email, String password, OnLoginFinishedListener listener) {
        loginListener = listener;
        mAuthTask = new UserLoginTask(email, password);
        mAuthTask.execute((Void) null);
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
           // showProgress(false);

            if (success) {
                loginListener.onSuccess();
            } else {
                loginListener.onError();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            //showProgress(false);
        }
    }
}
