package com.example.airnavigate.Views.Main.Deputies.Article;

import android.os.Bundle;

import com.example.airnavigate.Model.Deputy;
import com.example.airnavigate.R;
import com.example.airnavigate.Views.Base.BaseFragment;


public class DeputyArticleFragment extends BaseFragment implements IArticleView {





    public static DeputyArticleFragment newInstance(long deputyId) {
        Bundle bundle = new Bundle();
        bundle.putLong("deputy_id", deputyId);
        DeputyArticleFragment fragment = new DeputyArticleFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void displayDeputyInfo(Deputy deputy) {

    }


    @Override
    protected int getLayoutId() {
        return R.layout.main_deputy_article_fragment;
    }

    @Override
    public void displayError(Throwable error) {

    }
}
