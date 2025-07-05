package com.example.dbexample.activities;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.dbexample.R;
import com.example.dbexample.db.models.Movie;
import com.example.dbexample.db.provider.DBHelper;
import com.example.dbexample.db.provider.MovieTableHelper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /*

        Movie m = new Movie(1,"Forrest Gump",date,10);

        Log.i("myLog" , m.getName());
        Log.i("myLog" , m.getFromDate().toString());
        Log.i("myLog" , String.valueOf(m.getRank()));

         */
        /*
        DBHelper dbHelper = new DBHelper(MainActivity.this);

        dbHelper.getReadableDatabase();
         */
/*
        LocalDate date = LocalDate.of(1994,9,30);
        Movie movie = new Movie("Forrest Gump",date,10);
        MovieTableHelper movieTableHelper = new MovieTableHelper(MainActivity.this);
        movieTableHelper.insertNewMovie(movie);
*/

/*
        MovieTableHelper movieTableHelper = new MovieTableHelper(MainActivity.this);
        ArrayList<Movie> movies = movieTableHelper.getAllMovies();
        for (int i = 0; i < movies.size(); i++) {
            Toast.makeText(MainActivity.this, movies.get(i).getName(), Toast.LENGTH_SHORT).show();
        }
 */

        /*
        movieTableHelper.insertNewMovie(new Movie("mission imp 1",LocalDate.of(1994,11,3),5));
        movieTableHelper.insertNewMovie(new Movie("mission imp 2",LocalDate.of(1994,11,3),5));
        movieTableHelper.insertNewMovie(new Movie("mission imp 3",LocalDate.of(1994,11,3),5));
        movieTableHelper.insertNewMovie(new Movie("mission imp 4",LocalDate.of(1994,11,3),5));
        */
        MovieTableHelper movieTableHelper = new MovieTableHelper(MainActivity.this);
        Cursor cursor = movieTableHelper.getAllMovies();
        String[] columnsNames = {MovieTableHelper.MOVIE_TABLE_COLUMN_ID,MovieTableHelper.MOVIE_TABLE_COLUMN_NAME,
        MovieTableHelper.MOVIE_TABLE_COLUMN_FROM_DATE,MovieTableHelper.MOVIE_TABLE_COLUMN_RANK};
        int[] ids = {R.id.movieId,R.id.movieName,R.id.movieFromDate,R.id.movieRank};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                this,R.layout.movie_row,
                cursor,
                columnsNames,
                ids);
        ListView moviesListView = findViewById(R.id.moviesListView);
        moviesListView.setAdapter(adapter);

        adapter.changeCursor(cursor);
    }
}