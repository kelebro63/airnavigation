package com.example.airnavigate.Views.Login;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;

import com.example.airnavigate.Views.Common.SimpleAlertDialog;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * Created by Kelebro63 on 29.11.2015.
 */
public class LoginPresenterImpl implements LoginPresenter, OnLoginFinishedListener, OnValidateLoginFinishedListener, LoaderManager.LoaderCallbacks<Cursor>{

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    public static final int REQUEST_READ_CONTACTS = 0;

    private LoginView loginView;
    private LoginInteractor loginInteractor;
    private LoginActivity appContext;

    public LoginPresenterImpl(LoginView loginView, LoginActivity loginActivity) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
        this.appContext = loginActivity;
    }

    @Override
    public void ValidateCredentials(String username, String password) {
        this.loginView.showProgress();
        loginInteractor.validate(username, password, this);
    }


    private boolean mayRequestContacts() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (appContext.checkSelfPermission(READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        if (((LoginActivity) appContext).shouldShowRequestPermissionRationale(READ_CONTACTS)) {

            //this need be in View module
//            Snackbar.make(mEmailView, R.string.permission_rationale, Snackbar.LENGTH_INDEFINITE)
//                    .setAction(android.R.string.ok, new View.OnClickListener() {
//                        @Override
//                        @TargetApi(Build.VERSION_CODES.M)
//                        public void onClick(View v) {
//                            ((LoginActivity) appContext).requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
//                        }
//                    });
        } else {
            ((LoginActivity) appContext).requestPermissions(new String[]{READ_CONTACTS}, REQUEST_READ_CONTACTS);
        }
        return false;
    }

    @Override
    public void populateAutoComplete() {
        if (!mayRequestContacts()) {
            return;
        }

        ((LoginActivity) appContext).getLoaderManager().initLoader(0, null, this);
    }


    @Override
    public void attemptLogin(String email, String password) {
        loginView.showProgress();
        loginInteractor.validate(email, password, this);
    }

    @Override
    public void onEmailError() {
        loginView.setEmailError();
        loginView.hideProgress();
    }

    @Override
    public void onPasswordError() {
        loginView.setPasswordError();
        loginView.hideProgress();
    }

    @Override
    public void onSuccessValidate(String username, String password) {
        loginInteractor.login(username, password, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(appContext,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }
        this.loginView.loadFinished(emails);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    @Override
    public void onError() {

    }

    @Override
    public void onSuccess() {
        loginView.startMainScreen();
    }

    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }


}
