package com.example.airnavigate.Data;


import com.example.airnavigate.Internal.BackgroundThread;
import com.example.airnavigate.Model.Deputy;
import com.example.airnavigate.Model.News;
import com.example.airnavigate.Model.Topic;
import com.example.airnavigate.Utils.Prefs;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;

@SuppressWarnings("TryWithIdenticalCatches")
/**
 * Implementation of IDataSource, which uses server api as a primary source of information and local database as a cache
 * */
public class DataSourceImpl implements IDataSource {

    /**
     * An account for which we should ignore analytics
     */
//    private static final String EDITORIAL_ACCOUNT_TEAM_NAME = "FC GOKIXX All Stars";
//
//    /**
//     * Twitter user for which  we fetch the timeline
//     */
//    private static final String GOKIXX_TWITTER_ACCOUNT = "Gokixx";
//
    private final IAirNavigateAPI serverApi;
    private final DBManager manager;
    private final Prefs prefs;

    /**
     * Background scheduler which will be used to enqueue asynchronous tasks
     */
    private final Scheduler backgroundScheduler;


    @Inject
    public DataSourceImpl(IAirNavigateAPI serverApi,
                          @BackgroundThread Scheduler backgroundScheduler,
                          DBManager manager,
                          Prefs prefs) {

        this.serverApi = serverApi;
        this.manager = manager;
        this.prefs = prefs;
        this.backgroundScheduler = backgroundScheduler;
    }


    @Override
    public Observable<List<Topic>> requestGetNews() {
        return serverApi.requestLatestNews();
    }

    @Override
    public Observable<List<Deputy>> requestLoadDeputies() {
        return serverApi.requestLoadDeputies();
    }

    @Override
    public Observable<Deputy> requestLoadDeputy(int id) {
        return serverApi.requestLoadDeputy(id);
    }

    private List<News> getNews() {
        List<News> newsArrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            News news = new News(i);
            news.setTitle("title" + i);
            news.setSubtitle("subTitle" + i);
            newsArrayList.add(news);
        }
        return newsArrayList;
    }


}
