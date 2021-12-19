package com.example.toddler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.toddler.DatabaseContract.Color.COLOR_C1;
import static com.example.toddler.DatabaseContract.Color.COLOR_C3;
import static com.example.toddler.DatabaseContract.Color.TABLEcol_NAME;

public class MenuActivity extends AppCompatActivity {
DatabaseHelper databaseHelper;
ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //databaseHelper=new DatabaseHelper(this);

    }


    public void nextShapes(View view) {

        Intent i=new Intent(this,showShape.class);
        startActivity(i);
    }

    public void nextColor(View view) {
        Intent i=new Intent(this,Show_color.class);
        startActivity(i);
    }

    public void nextFruit(View view) {
        Intent i=new Intent(this,showFruit.class);
        startActivity(i);
    }

    public void nextQuiz(View view) {
        Intent i=new Intent(this,ShowQuiz.class);
        startActivity(i);
    }
}