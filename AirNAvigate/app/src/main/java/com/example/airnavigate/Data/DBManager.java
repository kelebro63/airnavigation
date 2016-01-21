package com.example.airnavigate.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.airnavigate.Dao.DaoMaster;
import com.example.airnavigate.Dao.DaoSession;
import com.example.airnavigate.Dao.Topic;
import com.example.airnavigate.Dao.TopicDao;
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

    @Inject
    public DBManager(@Singleton Context context, @Singleton Prefs prefs) {
        this.context = context;
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "airnavigate-db", null);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession session = daoMaster.newSession();
        topicDao = session.getTopicDao();

        this.prefs = prefs;
    }

    public void saveTopics(List<Topic> topicList) {
        for (Topic topic: topicList) {
            topicDao.insertOrReplace(topic);
        }
    }

    public List<Topic> getTopics() {
        return topicDao.loadAll();
    }
}
