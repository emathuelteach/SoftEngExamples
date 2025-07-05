package com.example.dbexample.db.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.dbexample.db.models.Movie;
import com.example.dbexample.db.models.Response;

import java.time.LocalDate;
import java.util.ArrayList;

public class MovieTableHelper {
    public static String MOVIE_TABLE_NAME = "Movie";
    public static String MOVIE_TABLE_COLUMN_ID = "_id";
    public static String MOVIE_TABLE_COLUMN_NAME = "name";
    public static String MOVIE_TABLE_COLUMN_FROM_DATE = "fromDate";
    public static String MOVIE_TABLE_COLUMN_RANK = "rank";


    private DBHelper dbHelper;
    public MovieTableHelper(Context context){
        dbHelper = new DBHelper(context);
    }

    public void insertNewMovie(Movie movie){
        Log.i("myAppDbLog" , "start insertNewMovie");
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( MOVIE_TABLE_COLUMN_NAME, movie.getName());
        String date = movie.getFromDate().toString();
        values.put( MOVIE_TABLE_COLUMN_FROM_DATE, date);
        values.put( MOVIE_TABLE_COLUMN_RANK, movie.getRank());
        long id = db.insert(MOVIE_TABLE_NAME,null,values);
        db.close();
        Log.i("myAppDbLog" , "end insertNewMovie");
        Log.i("myAppDbLog" , "new row id is: " + id);
    }

/*
    public ArrayList<Movie> getAllMovies(){
        Log.i("myAppDbLog" , "start getAllMovies");
        ArrayList<Movie> movies = new ArrayList<Movie>();
        String[] MOVIE_COLUMN_ARRAY = {MOVIE_TABLE_COLUMN_ID,MOVIE_TABLE_COLUMN_NAME,
                MOVIE_TABLE_COLUMN_FROM_DATE,MOVIE_TABLE_COLUMN_RANK};
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(MOVIE_TABLE_NAME,MOVIE_COLUMN_ARRAY,null,null,null,null,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String name = cursor.getString((int)cursor.getColumnIndex(MOVIE_TABLE_COLUMN_NAME));
            String fromDate = cursor.getString((int)cursor.getColumnIndex(MOVIE_TABLE_COLUMN_FROM_DATE));
            int rank = cursor.getInt((int)cursor.getColumnIndex(MOVIE_TABLE_COLUMN_RANK));
            Movie movie = new Movie(name, LocalDate.parse(fromDate),rank);
            movies.add(movie);
            cursor.moveToNext();
        }
        Log.i("myAppDbLog" , "end getAllMovies");
        db.close();
        return  movies;
    }
*/
    public Cursor getAllMovies(){
        Log.i("myAppDbLog" , "start getAllMovies");
        ArrayList<Movie> movies = new ArrayList<Movie>();
        String[] MOVIE_COLUMN_ARRAY = {MOVIE_TABLE_COLUMN_ID,MOVIE_TABLE_COLUMN_NAME,
                MOVIE_TABLE_COLUMN_FROM_DATE,MOVIE_TABLE_COLUMN_RANK};
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(MOVIE_TABLE_NAME,MOVIE_COLUMN_ARRAY,null,null,null,null,null);
        Log.i("myAppDbLog" , "end getAllMovies");
        return  cursor;
    }

}
