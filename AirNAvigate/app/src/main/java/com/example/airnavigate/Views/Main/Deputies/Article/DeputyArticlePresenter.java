package com.example.airnavigate.Views.Main.Deputies.Article;

import android.content.Context;

import com.example.airnavigate.MVP.IPresenter;
import com.example.airnavigate.Model.Deputy;
import com.example.airnavigate.Views.Base.BaseSubscriber;
import com.example.airnavigate.Views.Common.ErrorNavigator;
import com.example.airnavigate.Views.Main.MainInteractor;
import com.example.airnavigate.Views.Main.MainNavigator;

import javax.inject.Inject;


/**
 * Loads news into newsfeed. Controls pull-to-refresh.
 * Controls load more function by incrementing the number of the last fetched page
 */
class DeputyArticlePresenter implements IPresenter<IArticleView> {
    private IArticleView view;
    private final ErrorNavigator errorDisplayer;
    private final MainInteractor interactor;
    private final MainNavigator navigator;
    private final Context context;
    private boolean isLoading;

    @Inject
    public DeputyArticlePresenter(ErrorNavigator errorDisplayer, MainInteractor interactor, MainNavigator navigator, Context context) {
        this.errorDisplayer = errorDisplayer;
        this.interactor = interactor;
        this.navigator = navigator;
        this.context = context;
    }

    @Override
    public void takeView(IArticleView view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        interactor.unsubscribe();
    }

    public void requestDeputy(int id) {
        if (isLoading)
            return;
        interactor.loadDeputy(id, new BaseSubscriber<Deputy>(view) {
            @Override
            public void onStartImpl() {
                isLoading = true;
            }

            @Override
            public void onCompletedImpl() {
                isLoading = false;
            }

            @Override
            public void onErrorImpl(Throwable e) {
                isLoading = false;
                e.printStackTrace();
            }

            @Override
            public void onNextImpl(Deputy deputy) {
                view.displayDeputyInfo(deputy);
            }
        });
    }
}
