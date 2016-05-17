package com.example.airnavigate.Views.Base;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


/**
 * A base class for material-style dialog, with our design in mind.
 * That differs from {@link BaseDialog} in a way that it has no fixed areas and is fully customizable
 */
public abstract class BaseDialogFragment extends DialogFragment {

    private List<OnDialogDismissListener> listeners = new ArrayList<>();

    /**
     * Indacates that the dialog was dismissed with OK status
     */
    private boolean wasOk;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // Icepick.restoreInstanceState(this, savedInstanceState);
    }

    @LayoutRes
    protected abstract int getLayoutId();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
     //   Icepick.saveInstanceState(this, outState);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        //destroyPresenter();
    }



    /**
     * When you add the dialog D in front of any other fragment F, the fragment F is not paused.<br>
     * Thus it is not resumed when you dismiss the D. <br>
     * To keep track of the dialog state, just make your fragment F implement this interface
     */
    public interface OnDialogDismissListener {
        void onDismissedWithOk(boolean wasOk);
    }

    @Override
    public void onResume() {
        super.onResume();
        FragmentManager fm = getFragmentManager();
        List<Fragment> fragments = fm.getFragments();
        if (fragments != null) {
            for (Fragment f : fragments) {
                if (f instanceof OnDialogDismissListener) {
                    listeners.add((OnDialogDismissListener) f);
                }
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        listeners.clear();
    }


    @Override
    public void onDismiss(DialogInterface dialog) {
        for (OnDialogDismissListener l : listeners) {
            l.onDismissedWithOk(wasOk);
        }
        super.onDismiss(dialog);
    }


    public void dismiss(boolean wasOk) {
        setWasOk(wasOk);
        dismiss();
    }

    /**
     * In some cases the dialog is dismissed by back press or something like that.
     * In that kinda situations use this method to set the status in onDismiss()
     */
    protected void setWasOk(boolean wasOk) {
        this.wasOk = wasOk;
    }

}
