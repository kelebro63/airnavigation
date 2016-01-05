package com.example.airnavigate.Views.Main.Deputies.Article;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.airnavigate.Model.Deputy;
import com.example.airnavigate.Modules.MainActivityFragmentModule;
import com.example.airnavigate.MyApplication;
import com.example.airnavigate.R;
import com.example.airnavigate.Views.Base.BaseFragment;

import javax.inject.Inject;

import butterknife.Bind;


public class DeputyArticleFragment extends BaseFragment implements IArticleView {

    @Inject
    DeputyArticlePresenter presenter;
    private long deputyId;

    @Bind(R.id.deputy_name)
    TextView deputyName;


    public static DeputyArticleFragment newInstance(long deputyId) {
        Bundle bundle = new Bundle();
        bundle.putLong("deputy_id", deputyId);
        DeputyArticleFragment fragment = new DeputyArticleFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupActivityFragmentComponent();

        presenter.takeView(this);
        deputyId = getArguments().getLong("deputy_id");
        presenter.requestDeputy((int) deputyId);
    }

    public void setupActivityFragmentComponent() {
        //Uncomment those lines do measure dependencies creation time
        //Debug.startMethodTracing("SplashTrace");
        MyApplication.get(getActivity())
                .getAppComponent()
                .initMainActivityFragmentComponent(new MainActivityFragmentModule(this))
                .inject(this);
        //Debug.stopMethodTracing();
    }

    @Override
    public void displayDeputyInfo(Deputy deputy) {
        deputyName.setText(deputy.getName()+ " " + deputy.getFamily());
    }


    @Override
    protected int getLayoutId() {
        return R.layout.main_deputy_article_fragment;
    }

    @Override
    public void displayError(Throwable error) {

    }
}
