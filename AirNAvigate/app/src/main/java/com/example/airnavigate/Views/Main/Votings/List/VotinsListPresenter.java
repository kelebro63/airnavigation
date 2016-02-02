package com.example.airnavigate.Views.Main.Votings.List;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.airnavigate.Dao.Deputy;
import com.example.airnavigate.MVP.IPresenter;
import com.example.airnavigate.Model.Voting;
import com.example.airnavigate.Views.Base.BaseSubscriber;
import com.example.airnavigate.Views.Common.ErrorNavigator;
import com.example.airnavigate.Views.Main.MainInteractor;
import com.example.airnavigate.Views.Main.MainNavigator;

import java.util.List;

import javax.inject.Inject;


/**
 * Loads news into newsfeed. Controls pull-to-refresh.
 * Controls load more function by incrementing the number of the last fetched page
 */
class VotinsListPresenter implements IPresenter<IVotingsListView> { //http://lorempixel.com/
    private IVotingsListView view;
    private final ErrorNavigator errorDisplayer;
    private final MainInteractor interactor;
    private final MainNavigator navigator;
    private final Context context;
    private int currentPage = 1;
    private boolean isLoading;

    @Inject
    public VotinsListPresenter(ErrorNavigator errorDisplayer, MainInteractor interactor, MainNavigator navigator, Context context) {
        this.errorDisplayer = errorDisplayer;
        this.interactor = interactor;
        this.navigator = navigator;
        this.context = context;
    }

    @Override
    public void takeView(IVotingsListView view) {
        this.view = view;
    }


    /**
     * Request Deputes from data source. Paging is done automatically
     */
    public void requestVotings(int page) {
        if (isLoading)
            return;
        interactor.loadVotings(page, new BaseSubscriber<List<Voting>>(view) {
            @Override
            public void onStartImpl() {

            }

            @Override
            public void onCompletedImpl() {

            }

            @Override
            public void onErrorImpl(Throwable e) {

            }

            @Override
            public void onNextImpl(List<Voting> votings) {

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

            }

            @Override
            public void onCompletedImpl() {

            }

            @Override
            public void onErrorImpl(Throwable e) {

            }

            @Override
            public void onNextImpl(List<Deputy> newItems) {

            }
        });
    }


    public void openNextScreen(Deputy item, @Nullable String filter) {
        if (item == null ) {
            //thats unexpected
            if (item == null) {
               // Cr.e(this, new Throwable("item is null; filter is :" + filter));
            } else {
               // Cr.e(this, new Throwable("item is not null; contenttype is : " + item.getContentType() + " ; filter: " + filter));
            }
            //just don't crash please
            return;
        }
        navigator.openArticle((int) item.getId());
    }




    @Override
    public void destroy() {
        interactor.unsubscribe();
    }

}
