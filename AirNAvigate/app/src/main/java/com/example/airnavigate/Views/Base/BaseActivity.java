package com.example.airnavigate.Views.Base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.airnavigate.MyApplication;

/**
 * All the activities are expected to subclass this one
 */
public abstract class BaseActivity extends AppCompatActivity {

//    @Inject
//    protected SystemBarTintManager tintManager;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    //    maybeSetupTint();
    }

//    private void maybeSetupTint() {
//        if (tintManager != null && isStatusBarTintRequired()) {
//            tintManager.setStatusBarTintEnabled(true);
//            tintManager.setStatusBarAlpha(0.2f);
//        }
//    }

    /**
     * Override to return false if you don't want a status bar to be tinted
     */
    protected boolean isStatusBarTintRequired() {
        return true;
    }


//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
//    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
     //   Icepick.saveInstanceState(this, outState);
    }


    /**
     * Get the Main Application component for dependency injection.
     */
    public MyApplication getApplicationComponent() {
        return MyApplication.get(this);
    }


    public void setInProgress(boolean isInProgress) {
        if (isInProgress) {
            showProgress();
        } else {
            hideProgress();
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        hideProgress();
        destroyPresenter();
    }

    protected void showProgress() {
        if (progressDialog != null) {
            hideProgress();
        }
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();
    }

    protected void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    private void destroyPresenter() {
       // Utils.destroyPresenter(this);
    }
}
