package com.example.toddler;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

import static com.example.toddler.DatabaseContract.Color.COLOR_C1;
import static com.example.toddler.DatabaseContract.Color.COLOR_C3;
import static com.example.toddler.DatabaseContract.Color.TABLEcol_NAME;

public class ShowQuiz extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    String ShapeName[]=new String[3];
    int ShapePic[]=new int[3];
    String colName[]=new String[3];
    int colPic[]=new int[3];
    ImageView img;
    EditText edt;
    Button sub;
    Random r;
    int p=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_quiz);
        img=(ImageView)findViewById(R.id.imageView);
        edt=(EditText)findViewById(R.id.edit);
        sub=(Button)findViewById(R.id.sub);
        databaseHelper=new DatabaseHelper(this);
        r=new Random();
        /////
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String[] columns = { DatabaseContract.Shape._ID, DatabaseContract.Shape.SHAPE_C1, DatabaseContract.Shape.SHAPE_C2};
        String sortOrder = DatabaseContract.Shape._ID + " ASC";
        Cursor c = db.query(DatabaseContract.Shape.TABLEShape_NAME, columns, null, null, null, null, sortOrder);
        int i=-1;
        while (c.moveToNext()) {
            Long id= c.getLong(0) ;
            String name1= c.getString(1) ;
            int pic= c.getInt(2);
            ShapeName[i+1]=name1;
            ShapePic[i+1]=pic;
            i++;
        }
        c.close();
         p=r.nextInt(ShapePic.length);
        img.setImageResource(ShapePic[p]);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    Toast.makeText(ShowQuiz.this,"before loop",Toast.LENGTH_SHORT).show();
                for (int f=0;f<ShapeName.length;f++)
                {
                    if(f==p)
                    {
                       // Toast.makeText(ShowQuiz.this,"before if",Toast.LENGTH_SHORT).show();

                            if (ShapeName[p].equals(edt.getText().toString()))
                        {
                            Toast.makeText(ShowQuiz.this,"Right",Toast.LENGTH_SHORT).show();
                            Log.d("quiz",ShapeName[p]);
                        }
                            break;
                    }
                }
            }
        });

        db.close();
        /////
        /*String[] shcolumns = { DatabaseContract.Color._ID, COLOR_C1, COLOR_C3};
        String shsortOrder = DatabaseContract.Color._ID + " ASC";
        Cursor c1 = db.query(TABLEcol_NAME, columns, null, null, null, null, shsortOrder);
        int i1=-1;
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
        c.close();*/

    }
}