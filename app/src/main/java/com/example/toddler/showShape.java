package com.example.toddler;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.toddler.DatabaseContract.Color.COLOR_C1;
import static com.example.toddler.DatabaseContract.Color.COLOR_C3;
import static com.example.toddler.DatabaseContract.Color.TABLEcol_NAME;

public class showShape extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    TextView col1;
    TextView col2;
    TextView col3;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    String colName[]=new String[3];
    int colPic[]=new int[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_shape);
        col1=(TextView)findViewById(R.id.tr);
        col2=(TextView)findViewById(R.id.sh2);
        col3=(TextView)findViewById(R.id.sh3);
        img1=(ImageView)findViewById(R.id.imgtr);
        img2=(ImageView)findViewById(R.id.img2);
        img3=(ImageView)findViewById(R.id.img3);
        databaseHelper=new DatabaseHelper(this);
        databaseHelper.addShape();
        show_shape();
        final MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.triangle_tts);
        final MediaPlayer mediaPlayer2=MediaPlayer.create(this,R.raw.rectange_tts);
        final MediaPlayer mediaPlayer3=MediaPlayer.create(this,R.raw.circle_tts1);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer2.start();
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer3.start();
            }
        });
    }
    public void show_shape()
    {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String[] columns = { DatabaseContract.Shape._ID, DatabaseContract.Shape.SHAPE_C1, DatabaseContract.Shape.SHAPE_C2};
        String sortOrder = DatabaseContract.Shape._ID + " ASC";
        Cursor c = db.query(DatabaseContract.Shape.TABLEShape_NAME, columns, null, null, null, null, sortOrder);
        int i=-1;
        while (c.moveToNext()) {
            Long id= c.getLong(0) ;
            String name1= c.getString(1) ;
            int pic= c.getInt(2);
//            usersList.add( id+"-"+name1+ "("+Email+")" );
            Toast.makeText(this,"New Record Inserted: " + name1,Toast.LENGTH_SHORT).show();
            colName[i+1]=name1;
            colPic[i+1]=pic;
            i++;
        }
        c.close();
        col1.setText(colName[0]);
        col2.setText(colName[1]);
        col3.setText(colName[2]);
        img1.setImageResource(colPic[0]);
        img2.setImageResource(colPic[1]);
        img3.setImageResource(colPic[2]);
        db.close();
    }
}