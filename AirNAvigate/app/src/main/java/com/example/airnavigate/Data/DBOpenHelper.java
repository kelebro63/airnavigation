package com.example.airnavigate.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.airnavigate.Dao.DaoMaster;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by dtx12 on 01.09.2015.
 */
public class DBOpenHelper extends SQLiteAssetHelper {
    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
        DaoMaster.dropAllTables(db, true);
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        DaoMaster.createAllTables(db, true);
    }
}
