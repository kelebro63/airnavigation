package com.example.airnavigate.Views.Main.Deputies.List;

import android.content.Context;

import com.example.airnavigate.MVP.IPresenter;
import com.example.airnavigate.Model.Deputy;
import com.example.airnavigate.Views.Base.BaseSubscriber;
import com.example.airnavigate.Views.Common.ErrorNavigator;
import com.example.airnavigate.Views.Main.MainInteractor;
import com.example.airnavigate.Views.Main.ThematicBloks.TopicsNavigator;

import java.util.List;

import javax.inject.Inject;


/**
 * Loads news into newsfeed. Controls pull-to-refresh.
 * Controls load more function by incrementing the number of the last fetched page
 */
class DeputiesListPresenter implements IPresenter<IDeputiesListView> {
    private IDeputiesListView view;
    private final ErrorNavigator errorDisplayer;
    private final MainInteractor interactor;
    private final TopicsNavigator navigator;
    private final Context context;
    private int currentPage = 1;
    private boolean isLoading;

    @Inject
    public DeputiesListPresenter(ErrorNavigator errorDisplayer, MainInteractor interactor, TopicsNavigator navigator, Context context) {
        this.errorDisplayer = errorDisplayer;
        this.interactor = interactor;
        this.navigator = navigator;
        this.context = context;
    }

    @Override
    public void takeView(IDeputiesListView view) {
        this.view = view;
    }


    /**
     * Request news from data source. Paging is done automatically
     */
    public void requestDeputies() {
        if (isLoading)
            return;
        interactor.loadDeputies(new BaseSubscriber<List<Deputy>>(view) {
            @Override
            public void onStartImpl() {
                isLoading = true;
            }

            @Override
            public void onCompletedImpl() {
                isLoading = false;
                currentPage++;
            }

            @Override
            public void onErrorImpl(Throwable e) {
                isLoading = false;
                e.printStackTrace();
            }

            @Override
            public void onNextImpl(List<Deputy> deputies) {
                view.addDeputiesToDisplay(deputies);
            }
        });
    }

    /**
     * Refresh the contents by pull-to-refresh action. That discards all the newsfeed that is already loaded,
     * and starts everything from the beginning
     */
    public void refreshItems() {
        if (isLoading) {
            return;
        }
        interactor.loadDeputies(new BaseSubscriber<List<Deputy>>(view) {

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
                view.stopRefreshing();
            }

            @Override
            public void onNextImpl(List<Deputy> newItems) {
                view.stopRefreshing();
                //we reset the items. that is necessary so that user can further update their newsfeed, as usual
                view.setDeputiesToDisplay(newItems);
                currentPage = 2;//reset page
            }
        });
    }







    @Override
    public void destroy() {
        interactor.unsubscribe();
    }

}