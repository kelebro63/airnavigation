package com.example.airnavigate.Login;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;

import com.example.airnavigate.Main.MainActivity;
import com.example.airnavigate.R;

/**
 * Created by Kelebro63 on 29.11.2015.
 */
public class LoginInteractorImpl implements LoginInteractor{

    private UserLoginTask mAuthTask = null;

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {




//        new Handler().postDelayed(new Runnable() {
//            @Override public void run() {
//                boolean error = false;
//                if (TextUtils.isEmpty(username)){
//                    listener.onUsernameError();
//                    error = true;
//                }
//                if (TextUtils.isEmpty(password)){
//                    listener.onPasswordError();
//                    error = true;
//                }
//                if (!error){
//                    listener.onSuccess();
//                }
//            }
//        }, 2000);
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
            showProgress(false);

            if (success) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}
