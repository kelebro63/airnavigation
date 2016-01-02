package com.example.airnavigate.Views.Main.ThematicBloks;


import android.text.TextUtils;

import com.example.airnavigate.Data.IDataSource;
import com.example.airnavigate.Internal.BackgroundThread;
import com.example.airnavigate.Internal.MainThread;
import com.example.airnavigate.MVP.Interactor;
import com.example.airnavigate.Model.News;

import java.util.List;

import javax.inject.Inject;

import rx.Scheduler;
import rx.Subscriber;


public class NewsInteractor extends Interactor {
    private final IDataSource dataSource;

    @Inject
    public NewsInteractor(@MainThread Scheduler mainThreadScheduler, @BackgroundThread Scheduler backgroundThreadScheduler, IDataSource dataSource) {
        super(mainThreadScheduler, backgroundThreadScheduler);
        this.dataSource = dataSource;
    }

    public void loadNews(int page, Subscriber<List<News>> subscriber) {
        //subscribe(dataSource.requestLatestNews(page), subscriber);
    }

    public void loadNews(int page, String filter, Subscriber<List<News>> subscriber) {
        if (TextUtils.isEmpty(filter)) {
            loadNews(page, subscriber);
        } else {
           // subscribe(dataSource.requestLatestNews(page, filter), subscriber);
        }
    }

}
