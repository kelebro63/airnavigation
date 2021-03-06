package com.example.airnavigate.Data;


import com.example.airnavigate.Dao.Deputy;
import com.example.airnavigate.Dao.Topic;
import com.example.airnavigate.Dao.VotingResult;
import com.example.airnavigate.Internal.BackgroundThread;
import com.example.airnavigate.Utils.Prefs;

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

//
//    /**
//     * Twitter user for which  we fetch the timeline
//     */

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
    public Observable<List<Topic>> requestGetTopics() {
        return serverApi.requestLoadTopics()
                .doOnNext(manager::saveTopics)
                .onErrorResumeNext(
                        Observable.just(manager.getTopics())
                );
    }

    @Override
    public Observable<List<Deputy>> requestLoadDeputies() {
        return serverApi.requestLoadDeputies()
                .doOnNext(manager::saveDeputies)
                .onErrorResumeNext(
                        Observable.<List<Deputy>>empty().just(manager.getDeputies())
                );
    }

    @Override
    public Observable<Deputy> requestLoadDeputy(int id) {
        return serverApi.requestLoadDeputy(id)
                .doOnNext(manager::saveDeputy);
    }

    @Override
    public Observable<VotingResult> requestLoadVotings(int page) {
        return serverApi.requestLoadVotings(page)
                .doOnNext(manager::saveVoting);
    }


}
