package com.example.airnavigate.Views.Main.Votings.List;

import android.content.Context;

import com.example.airnavigate.Dao.Deputy;
import com.example.airnavigate.MVP.IPresenter;
import com.example.airnavigate.Dao.VotingResult;
import com.example.airnavigate.Views.Base.BaseSubscriber;
import com.example.airnavigate.Views.Common.ErrorNavigator;
import com.example.airnavigate.Views.Main.MainInteractor;
import com.example.airnavigate.Views.Main.MainNavigator;

import javax.inject.Inject;


/**
 * Loads news into newsfeed. Controls pull-to-refresh.
 * Controls load more function by incrementing the number of the last fetched page
 */
class VotinsListPresenter implements IPresenter<IVotingsListView> {
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
    public void requestVotings() {
        if (isLoading)
            return;
        interactor.loadVotings(currentPage, new BaseSubscriber<VotingResult>(view) {
            @Override
            public void onStartImpl() {
                isLoading = true;
                //view.setInProgress(true);
            }

            @Override
            public void onCompletedImpl() {
                isLoading = false;
                currentPage++;
                //view.setInProgress(false);
            }

            @Override
            public void onErrorImpl(Throwable e) {

            }

            @Override
            public void onNextImpl(VotingResult votingResult) {
                view.addVotingsToDisplay(votingResult.getVotes());
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
        currentPage = 1;
        interactor.loadVotings(currentPage, new BaseSubscriber<VotingResult>(view) {
            @Override
            public void onStartImpl() {
                isLoading = true;
                //view.setInProgress(true);
            }

            @Override
            public void onCompletedImpl() {
                view.stopRefreshing();
                isLoading = false;
                currentPage++;
                //view.setInProgress(false);
            }

            @Override
            public void onErrorImpl(Throwable e) {

            }

            @Override
            public void onNextImpl(VotingResult votingResult) {
                view.setVotingsToDisplay(votingResult.getVotes());
            }
        });
    }


    public void openNextScreen(Deputy item) {
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
