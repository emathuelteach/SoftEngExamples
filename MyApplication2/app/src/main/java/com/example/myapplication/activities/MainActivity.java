package com.example.myapplication.activities;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.R;
import com.example.myapplication.db.models.Game;
import com.example.myapplication.db.provider.DBHelper;
import com.example.myapplication.db.provider.GameTableHelper;

import java.time.LocalDateTime;
import java.util.Calendar;

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

        DBHelper dbHelper = new DBHelper(MainActivity.this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        db = dbHelper.getWritableDatabase();

        Game newGame = new Game(7, "","","started",0);
        GameTableHelper gh = new GameTableHelper(MainActivity.this);
        gh.insertNewGame(newGame);
    }
}