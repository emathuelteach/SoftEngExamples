package com.example.dbexample.db.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION  = 5;

    public DBHelper(@Nullable Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("myAppDbLog" , "Start onCreate db");
        String createMovieTable = String.format(
                "create table %s (%s integer primary key autoincrement,%s text,%s date,%s integer)",
                MovieTableHelper.MOVIE_TABLE_NAME,
                MovieTableHelper.MOVIE_TABLE_COLUMN_ID,
                MovieTableHelper.MOVIE_TABLE_COLUMN_NAME,
                MovieTableHelper.MOVIE_TABLE_COLUMN_FROM_DATE,
                MovieTableHelper.MOVIE_TABLE_COLUMN_RANK
        );
        db.execSQL(createMovieTable);
        Log.i("myAppDbLog" , "End onCreate db");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("myAppDbLog" , "Start onUpgrade db");
        Log.i("myAppDbLog" , "old version " + oldVersion + ", new version " + newVersion);
        String dropMovieTable = String.format(
                "drop table if exists %s",
                MovieTableHelper.MOVIE_TABLE_NAME
        );
        db.execSQL(dropMovieTable);
        onCreate(db);
        Log.i("myAppDbLog" , "End onUpgrade db");
    }
}
