package com.example.toddler;

import android.provider.BaseColumns;

public final class DatabaseContract {

    public DatabaseContract() {}

    /* Inner class that defines the table contents */
    public static abstract class Color implements BaseColumns {
        public static final String TABLEcol_NAME = "color";
         public static final String COLOR_C1 = "cname";
       //  public static final String COLOR_C2= "speech";
       public static final String COLOR_C3 = "image";
        }
        public static abstract class Shape implements BaseColumns {
        public static final String TABLEShape_NAME = "shape";
        public static final String SHAPE_C1 = "sName";
        public static final String SHAPE_C2= "shapePic";
      }
    public static abstract class Fruit implements BaseColumns {
        public static final String TABLEFruit_NAME = "fruit";
        public static final String FRUIT_C1 = "frName";
       public static final String FRUIT_C2= "frPic";
      }

}