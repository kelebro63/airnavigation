package com.example.airnavigate.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.airnavigate.Dao.DaoMaster;
import com.example.airnavigate.Dao.DaoSession;
import com.example.airnavigate.Dao.Deputy;
import com.example.airnavigate.Dao.DeputyDao;
import com.example.airnavigate.Dao.Topic;
import com.example.airnavigate.Dao.TopicDao;
import com.example.airnavigate.Model.Voting;
import com.example.airnavigate.Utils.Prefs;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Kelebro63 on 03.01.2016.
 */
public class DBManager {

    private final Prefs prefs;
    private final Context context;
    private final TopicDao topicDao;
    private final DeputyDao deputyDao;

    @Inject
    public DBManager(@Singleton Context context, @Singleton Prefs prefs) {
        this.context = context;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "airnavigate-db", null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession session = daoMaster.newSession();
        topicDao = session.getTopicDao();
        deputyDao = session.getDeputyDao();
        this.prefs = prefs;
    }

    public void saveTopics(List<Topic> topicList) {
        for (Topic topic: topicList) {
            topicDao.insertOrReplace(topic);
        }
    }

    public void saveDeputies(List<Deputy> deputyList) {
        for (Deputy deputy: deputyList) {
            deputyDao.insertOrReplace(deputy);
        }
    }

    public void saveDeputy(Deputy deputy) {
        deputyDao.insertOrReplace(deputy);
    }

    public void saveVoting(List<Voting> votings) {
        //deputyDao.insertOrReplace(voting);
    }

    public List<Topic> getTopics() {
        return topicDao.loadAll();
    }

    public List<Deputy> getDeputies() {
        return deputyDao.loadAll();
    }
}
