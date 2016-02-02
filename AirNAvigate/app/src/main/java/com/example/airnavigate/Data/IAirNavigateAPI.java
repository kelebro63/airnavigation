package com.example.airnavigate.Data;

// IMPROVEMENT: This interface should further be  done package-local, so that no one uses it outside of Datasource


import com.example.airnavigate.Dao.Deputy;
import com.example.airnavigate.Dao.Topic;
import com.example.airnavigate.Model.Voting;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface IAirNavigateAPI {

    @GET("/topics.json")
    Observable<List<Topic>> requestLoadTopics();

    @GET("/deputies.json")
    Observable<List<Deputy>> requestLoadDeputies();

    @GET("/deputy.json")
    Observable<Deputy> requestLoadDeputy(@Query("id") int id);

    @GET("/voteSearch.json")
    Observable<List<Voting>> requestLoadVotings(@Query("page") int page);

}
