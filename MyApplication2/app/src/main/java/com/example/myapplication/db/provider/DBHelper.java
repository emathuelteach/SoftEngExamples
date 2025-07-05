package com.example.myapplication.db.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;


public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 4;

    public static String DB_LOG_NAME = "dbLog";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i(DB_LOG_NAME , "onCreate Sqlite DataBase");
        String createGameTable = String.format(
                "create table %s (%s integer primary key autoincrement, %s text , %s text , %s text , %s integer)",
                GameTableHelper.GAME_TABLE_NAME,
                GameTableHelper.GAME_COLUMN_NAME_ID,
                GameTableHelper.GAME_COLUMN_NAME_START_DATE_TIME,
                GameTableHelper.GAME_COLUMN_NAME_END_DATE_TIME,
                GameTableHelper.GAME_COLUMN_NAME_STATE,
                GameTableHelper.GAME_COLUMN_NAME_WINNER_ID
        );
        sqLiteDatabase.execSQL(createGameTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i(DB_LOG_NAME , "onUpgrade Sqlite DataBase to version :" + DATABASE_VERSION);
        String drop = String.format("drop table if exists %s" ,GameTableHelper.GAME_TABLE_NAME);
        sqLiteDatabase.execSQL(drop);
        onCreate(sqLiteDatabase);
    }
}
