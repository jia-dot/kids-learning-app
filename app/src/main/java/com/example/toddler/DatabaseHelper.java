package com.example.toddler;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import static com.example.toddler.DatabaseContract.Color.COLOR_C1;
import static com.example.toddler.DatabaseContract.Color.COLOR_C3;
import static com.example.toddler.DatabaseContract.Color.TABLEcol_NAME;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "toddler.db";

    private static final String CREATE_TBL_COLOR= "CREATE TABLE "
            + DatabaseContract.Color.TABLEcol_NAME + " ("
            + DatabaseContract.Color._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLOR_C1 + " TEXT NOT NULL,"
            + DatabaseContract.Color.COLOR_C3 + " TEXT NOT NULL)";
        //    + DatabaseContract.Color.COLOR_C2 + " TEXT)";
        private static final String CREATE_TBL_SHAPE= "CREATE TABLE "
                + DatabaseContract.Shape.TABLEShape_NAME + " ("
                + DatabaseContract.Shape._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DatabaseContract.Shape.SHAPE_C1 + " TEXT NOT NULL,"
                + DatabaseContract.Shape.SHAPE_C2 + " TEXT)";
    private static final String CREATE_TBL_FRUIT= "CREATE TABLE "
            + DatabaseContract.Fruit.TABLEFruit_NAME + " ("
            + DatabaseContract.Fruit._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DatabaseContract.Fruit.FRUIT_C1 + " TEXT NOT NULL,"
            + DatabaseContract.Fruit.FRUIT_C2 + " TEXT)";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
       // addColor();
        //addFruit();
       //addShape();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub
        db.execSQL(CREATE_TBL_COLOR);
        db.execSQL(CREATE_TBL_FRUIT);
        db.execSQL(CREATE_TBL_SHAPE);
        //addShape();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

// TODO Auto-generated method stub

    }
    public void addColor() {
        SQLiteDatabase dbr=this.getReadableDatabase();
        long count= DatabaseUtils.queryNumEntries(dbr, TABLEcol_NAME);
        if (count<3)
        {
            SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLOR_C1,"RED");
        values.put(COLOR_C3,R.drawable.red1);
        ContentValues values1 = new ContentValues();
        values1.put(COLOR_C1,"YELLOW");
        values1.put(COLOR_C3,R.drawable.yellow1);
        ContentValues values2 = new ContentValues();
        values2.put(COLOR_C1,"BLUE");
        values2.put(COLOR_C3,R.drawable.blue1);

        long newRowId=db.insert(TABLEcol_NAME, null, values);
        long newRowId2=db.insert(TABLEcol_NAME, null, values1);
        long newRowId3=db.insert(TABLEcol_NAME, null, values2);
        Log.d("inserted","color"+newRowId+newRowId2+newRowId3);
        db.close();
    }}
    public void addShape()
    {
        SQLiteDatabase dbr=this.getReadableDatabase();
        long count= DatabaseUtils.queryNumEntries(dbr, DatabaseContract.Shape.TABLEShape_NAME);
        if (count<3)
        {
            SQLiteDatabase db=this.getReadableDatabase();
            ContentValues values = new ContentValues();
            values.put(DatabaseContract.Shape.SHAPE_C1, "Triangle");
            values.put(DatabaseContract.Shape.SHAPE_C2, R.drawable.traingle);
            ContentValues values1 = new ContentValues();
            values1.put(DatabaseContract.Shape.SHAPE_C1, "Rectangle");
            values1.put(DatabaseContract.Shape.SHAPE_C2, R.drawable.rectangle);
            ContentValues values2 = new ContentValues();
            values2.put(DatabaseContract.Shape.SHAPE_C1, "Circle");
            values2.put(DatabaseContract.Shape.SHAPE_C2, R.drawable.circle);
            long newRowId = db.insert(DatabaseContract.Shape.TABLEShape_NAME, null, values);
            long newRowId2 = db.insert(DatabaseContract.Shape.TABLEShape_NAME, null, values1);
            long newRowId3 = db.insert(DatabaseContract.Shape.TABLEShape_NAME, null, values2);
            Log.d("Shinserted", "color" + newRowId + newRowId2 + newRowId3);
            //   if (newRowId > 0) {
            // Toast.makeText(this,"New Record Inserted: " + newRowId,Toast.LENGTH_SHORT).show();
            //    }

        }
    }
    public  void addFruit()
    {SQLiteDatabase dbr=this.getReadableDatabase();
long count= DatabaseUtils.queryNumEntries(dbr, DatabaseContract.Fruit.TABLEFruit_NAME);
        if (count<3)
        {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.Fruit.FRUIT_C1,"Apple");
        values.put(DatabaseContract.Fruit.FRUIT_C2,R.drawable.apple);
        ContentValues values1 = new ContentValues();
        values1.put(DatabaseContract.Fruit.FRUIT_C1,"Mango");
        values1.put(DatabaseContract.Fruit.FRUIT_C2,R.drawable.mango);
        ContentValues values2 = new ContentValues();
        values2.put(DatabaseContract.Fruit.FRUIT_C1,"Banana");
        values2.put(DatabaseContract.Fruit.FRUIT_C2,R.drawable.banana);
        long newRowId=db.insert(DatabaseContract.Fruit.TABLEFruit_NAME, null, values);
        long newRowId2=db.insert(DatabaseContract.Fruit.TABLEFruit_NAME, null, values1);
        long newRowId3=db.insert(DatabaseContract.Fruit.TABLEFruit_NAME, null, values2);
        Log.d("FRinserted","color"+newRowId+newRowId2+newRowId3);
        //   if (newRowId > 0) {
        // Toast.makeText(this,"New Record Inserted: " + newRowId,Toast.LENGTH_SHORT).show();
        //    }
    }}

}