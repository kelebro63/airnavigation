package com.example.airnavigate.Views.Main.ThematicBloks;

import android.content.Context;
import android.support.annotation.Nullable;

import com.example.airnavigate.MVP.IPresenter;
import com.example.airnavigate.Model.Topic;
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
class TopicsListPresenter implements IPresenter<ITopicsListView> {
    private ITopicsListView view;
    private final ErrorNavigator errorDisplayer;
    private final MainInteractor interactor;
    private final MainNavigator navigator;
    private final Context context;
    private int currentPage = 1;
    private boolean isLoading;

    @Inject
    public TopicsListPresenter(ErrorNavigator errorDisplayer, MainInteractor interactor, MainNavigator navigator, Context context) {
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

    public void openNextScreen(Topic item, @Nullable String filter) {

        String test = "";
//        if (item == null || item.getContentType() == null) {
//            //thats unexpected
//            if (item == null) {
//                Cr.e(this, new Throwable("item is null; filter is :" + filter));
//            } else {
//                Cr.e(this, new Throwable("item is not null; contenttype is : " + item.getContentType() + " ; filter: " + filter));
//            }
//            //just don't crash please
//            return;
//        }
//
//        StringArrayList tags = item.getTags();
//
//        EventTracker tracker = GokixxApp.analytixx(context).eventTracker;
//        String tag = null;
//        if (tags != null && tags.size() > 0) {
//            tag = tags.get(0);
//        }
//
//        if (item.getContentType().equals(ContentType.NEWS.value())) {
//
//
//            navigator.openArticle(item.getId(), tag);
//            if (filter == null) {
//                tracker.trackArticleOpenFromNewsfeed(item.getTitle());
//            } else {
//                tracker.trackArticleOpenFromHashtags(item.getTitle(), filter);
//            }
//
//        } else if (item.getContentType().equals(ContentType.VIDEO.value())) {
//            openYoutubeVideo(item);
//            if (filter == null) {
//                tracker.trackClickVideoItemFromNewsfeed(item.getTitle());
//            } else {
//                tracker.trackClickVideoItemFromHashtagsTab(item.getTitle(), filter);
//            }
//        } else {
//            navigator.openTwitterPost(item.getId(), tag);
//            if (filter == null) {
//                tracker.trackTweetOpenFromNewsfeed(item.getTitle());
//            } else {
//                tracker.trackTweetOpenFromHashtags(item.getTitle(), filter);
//            }
//        }
    }

    @Override
    public void destroy() {
        interactor.unsubscribe();
    }

}
