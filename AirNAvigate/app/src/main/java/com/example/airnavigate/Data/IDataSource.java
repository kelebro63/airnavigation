package com.example.airnavigate.Data;

import com.example.airnavigate.Dao.Deputy;
import com.example.airnavigate.Dao.Topic;
import com.example.airnavigate.Dao.VotingResult;

import java.util.List;

import rx.Observable;


public interface IDataSource {

    Observable<List<Topic>> requestGetTopics();

    Observable<List<Deputy>> requestLoadDeputies();

    Observable<Deputy> requestLoadDeputy(int id);

    Observable<VotingResult> requestLoadVotings(int page);

}