package com.example.myapplication.db.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.db.models.Game;

public class GameTableHelper {
    public static String GAME_TABLE_NAME = "Game";
    public static String GAME_COLUMN_NAME_ID = "id";
    public static String GAME_COLUMN_NAME_START_DATE_TIME = "startDateTime";
    public static String GAME_COLUMN_NAME_END_DATE_TIME = "endDateTime";
    public static String GAME_COLUMN_NAME_STATE = "state";
    public static String GAME_COLUMN_NAME_WINNER_ID = "winnerId";

    private DBHelper dbHelper;
    public GameTableHelper(Context context) {
        dbHelper = new DBHelper(context);
    }
    public void insertNewGame(Game game){
        try{
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(GAME_COLUMN_NAME_ID,game.getId());
            values.put(GAME_COLUMN_NAME_START_DATE_TIME,game.getStartDateTime());
            values.put(GAME_COLUMN_NAME_END_DATE_TIME,game.getEndDateTime());
            values.put(GAME_COLUMN_NAME_STATE,game.getState());
            values.put(GAME_COLUMN_NAME_WINNER_ID,game.getWinnerId());
            long i = db.insert(GAME_TABLE_NAME,null,values);
            db.close();
            Log.i(DBHelper.DB_LOG_NAME, String.valueOf(i));
        }
        catch (Exception e){
            Log.e(DBHelper.DB_LOG_NAME, e.getMessage());
        }

    }
}
