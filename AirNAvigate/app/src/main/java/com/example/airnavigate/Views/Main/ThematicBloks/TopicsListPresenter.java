package com.example.airnavigate.Views.Main.ThematicBloks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.airnavigate.MVP.IPresenter;
import com.example.airnavigate.Model.Topic;
import com.example.airnavigate.Views.Base.BaseSubscriber;
import com.example.airnavigate.Views.Common.ErrorNavigator;

import java.util.List;

import javax.inject.Inject;


/**
 * Loads news into newsfeed. Controls pull-to-refresh.
 * Controls load more function by incrementing the number of the last fetched page
 */
class TopicsListPresenter implements IPresenter<ITopicsListView> {
    private ITopicsListView view;
    private final ErrorNavigator errorDisplayer;
    private final TopicsInteractor interactor;
    private final TopicsNavigator navigator;
    private final Context context;
    private int currentPage = 1;
    private boolean isLoading;

    @Inject
    public TopicsListPresenter(ErrorNavigator errorDisplayer, TopicsInteractor interactor, TopicsNavigator navigator, Context context) {
        this.errorDisplayer = errorDisplayer;
        this.interactor = interactor;
        this.navigator = navigator;
        this.context = context;
    }

    @Override
    public void takeView(ITopicsListView view) {
        this.view = view;
    }


    /**
     * Request news from data source. Paging is done automatically
     */
    public void requestTopics(@Nullable String filter) {
        if (isLoading)
            return;
        interactor.getTopics(new BaseSubscriber<List<Topic>>(view) {
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
            public void onNextImpl(List<Topic> news) {
                view.addTopicsToDisplay(news);
            }
        });
    }

    /**
     * Refresh the contents by pull-to-refresh action. That discards all the newsfeed that is already loaded,
     * and starts everything from the beginning
     */
    public void refreshItems(@Nullable String filter) {
        if (isLoading) {
            return;
        }
        interactor.getTopics(new BaseSubscriber<List<Topic>>(view) {

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
            public void onNextImpl(List<Topic> newItems) {
                view.stopRefreshing();
                //we reset the items. that is necessary so that user can further update their newsfeed, as usual
                view.setTopicsToDisplay(newItems);
                currentPage = 2;//reset page
            }
        });
    }







    @Override
    public void destroy() {
     //   interactor.unsubscribe();
    }

}
