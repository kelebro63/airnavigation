package com.example.airnavigate.Views.Common;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentManager;

import com.example.airnavigate.R;
import com.example.airnavigate.Views.Base.BaseDialog;


/**
 * A simple fragment-based alert dialog with gokixx styling
 * */
public class SimpleAlertDialog extends BaseDialog {
    @Override
    protected void onRightBtnClickImpl() {
        dismiss(false);
    }

    @Override
    protected void onLeftBtnClickImpl() {
        dismiss(false);
    }

    @Nullable
    @Override
    protected String getLeftBtnTitle() {
        return null;
    }

    @Nullable
    @Override
    protected String getRightBtnTitle() {
        return getString(R.string.ok);
    }

    @Nullable
    @Override
    protected String getTitle() {
        return getType() == ArgType.RESOURCE ? getString(getIntFromArgs("title")) : getStringFromArgs("title");
    }

    @Nullable
    @Override
    protected String getMessage() {
        return getType() == ArgType.RESOURCE ? getString(getIntFromArgs("message")) : getStringFromArgs("message");
    }

    private ArgType getType() {
        return (ArgType) getArguments().getSerializable("type");
    }

    @Nullable
    private String getStringFromArgs(String key) {
        return getArguments().getString(key);
    }

    @Nullable
    private int getIntFromArgs(String key) {
        return getArguments().getInt(key, -1);
    }

    public static void show(FragmentManager fm, String title, String message) {
        Bundle args = new Bundle();
        args.putSerializable("type", ArgType.STRING);
        args.putString("title", title);
        args.putString("message", message);
        showInternal(fm, args);
    }


    public static void show(FragmentManager fm, @StringRes int title, @StringRes int message) {
        Bundle args = new Bundle();
        args.putSerializable("type", ArgType.RESOURCE);
        args.putInt("title", title);
        args.putInt("message", message);
        showInternal(fm, args);
    }

    private static void showInternal(FragmentManager fm, Bundle args) {
        SimpleAlertDialog dialog = new SimpleAlertDialog();
        dialog.setArguments(args);
        dialog.show(fm, SimpleAlertDialog.class.getSimpleName());
    }

    protected enum ArgType {
        STRING, RESOURCE
    }
}
