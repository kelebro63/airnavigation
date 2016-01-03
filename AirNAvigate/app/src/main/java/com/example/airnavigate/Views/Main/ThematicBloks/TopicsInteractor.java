package com.example.airnavigate.Views.Main.ThematicBloks;


import android.text.TextUtils;

import com.example.airnavigate.Data.IDataSource;
import com.example.airnavigate.Internal.BackgroundThread;
import com.example.airnavigate.Internal.MainThread;
import com.example.airnavigate.MVP.Interactor;
import com.example.airnavigate.Model.News;
import com.example.airnavigate.Model.Topic;

import java.util.List;

import javax.inject.Inject;

import rx.Scheduler;
import rx.Subscriber;


public class TopicsInteractor extends Interactor {
    private final IDataSource dataSource;

    @Inject
    public TopicsInteractor(@MainThread Scheduler mainThreadScheduler, @BackgroundThread Scheduler backgroundThreadScheduler, IDataSource dataSource) {
        super(mainThreadScheduler, backgroundThreadScheduler);
        this.dataSource = dataSource;
    }

    public void loadTopics(int page, Subscriber<List<News>> subscriber) {
        //subscribe(dataSource.requestLatestNews(page), subscriber);
    }

    public void loadTopics(int page, String filter, Subscriber<List<News>> subscriber) {
        if (TextUtils.isEmpty(filter)) {
            loadTopics(page, subscriber);
        } else {
           // subscribe(dataSource.requestLatestNews(page, filter), subscriber);
        }
    }

    public void getTopics(Subscriber<List<Topic>> subscriber) {
        subscribe(dataSource.requestGetNews("app752bd9901d986ec138dccfc56336a83f0af88134"), subscriber);
    }

}
