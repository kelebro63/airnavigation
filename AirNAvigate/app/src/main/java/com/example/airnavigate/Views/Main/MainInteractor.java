package com.example.airnavigate.Views.Main;


import com.example.airnavigate.Data.IDataSource;
import com.example.airnavigate.Internal.BackgroundThread;
import com.example.airnavigate.Internal.MainThread;
import com.example.airnavigate.MVP.Interactor;
import com.example.airnavigate.Model.Deputy;
import com.example.airnavigate.Model.Topic;

import java.util.List;

import javax.inject.Inject;

import rx.Scheduler;
import rx.Subscriber;


public class MainInteractor extends Interactor {
    private final IDataSource dataSource;

    @Inject
    public MainInteractor(@MainThread Scheduler mainThreadScheduler, @BackgroundThread Scheduler backgroundThreadScheduler, IDataSource dataSource) {
        super(mainThreadScheduler, backgroundThreadScheduler);
        this.dataSource = dataSource;
    }

    public void getTopics(Subscriber<List<Topic>> subscriber) {
        subscribe(dataSource.requestGetNews(), subscriber);
    }

    public void loadDeputies(Subscriber<List<Deputy>> subscriber) {
        subscribe(dataSource.requestLoadDeputies(), subscriber);
    }

}
