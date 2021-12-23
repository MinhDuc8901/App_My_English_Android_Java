package com.example.myenglish.Controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;

import androidx.annotation.Nullable;

public class NoteSQLite extends SQLiteOpenHelper {
    public  static final String DATABASE_NAME = "mynotes.db";
    public  static final String TABLE_NAME= "notes";
    public  static final String COLUMN_ID ="_id";
    public  static final String COLUMN_NOTE = "note";
    public static final int DATABASE_VERSION = 1;
    private static final String CREATE_DATABASE = "CREATE TABLE "+TABLE_NAME +"( "
                                                    + COLUMN_ID+" INTEGER PRIMARY KEY autoincrement , "
                                                    +COLUMN_NOTE+" text not null ) ;";

    public NoteSQLite(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
