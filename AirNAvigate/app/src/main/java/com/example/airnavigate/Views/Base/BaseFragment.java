package com.example.airnavigate.Views.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.airnavigate.MyApplication;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {


    protected abstract int getLayoutId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LayoutInflater actualInflater = getThemedInflater() == null ? inflater : getThemedInflater();
        View view = actualInflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    /**
     * Override to return themed inflater
     */
    @Nullable
    protected LayoutInflater getThemedInflater() {
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        destroyPresenter();
    }

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return null; //componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }


    protected final MyApplication getAppComponent() {
        return ((BaseActivity) getActivity()).getApplicationComponent();
    }


    public void setInProgress(boolean isInProgress) {
        ((BaseActivity) getActivity()).setInProgress(isInProgress);
    }

    private void destroyPresenter() {
        //Utils.destroyPresenter(this);
    }

    /**
     * Used to retrieve a tag for this fragment
     */
    public String provideTag() {
        return getClass().getSimpleName();
    }
}
