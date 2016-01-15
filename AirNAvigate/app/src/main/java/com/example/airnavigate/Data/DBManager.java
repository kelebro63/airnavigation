package com.example.airnavigate.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.airnavigate.Dao.DaoMaster;
import com.example.airnavigate.Dao.DaoSession;
import com.example.airnavigate.Utils.Prefs;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Kelebro63 on 03.01.2016.
 */
public class DBManager {

    private final Prefs prefs;
    private final Context context;

    @Inject
    public DBManager(@Singleton Context context, @Singleton Prefs prefs) {
        this.context = context;
        DBOpenHelper helper = new DBOpenHelper(context, "gokixx-db", null, 1);
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        DaoSession session = daoMaster.newSession();

        this.prefs = prefs;
    }


}
