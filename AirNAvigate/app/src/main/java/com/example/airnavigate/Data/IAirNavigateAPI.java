package com.example.airnavigate.Data;

// IMPROVEMENT: This interface should further be  done package-local, so that no one uses it outside of Datasource


import com.example.airnavigate.Model.Deputy;
import com.example.airnavigate.Model.Topic;

import java.util.List;

import retrofit.http.GET;
import rx.Observable;

public interface IAirNavigateAPI {

    @GET("/topics.json")
    Observable<List<Topic>> requestLatestNews();

    @GET("/deputies.json")
    Observable<List<Deputy>> requestLoadDeputies();

}
