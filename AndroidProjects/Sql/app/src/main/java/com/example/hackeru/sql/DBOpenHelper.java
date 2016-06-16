package com.example.hackeru.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "maayanDB.db"; // end with ".db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_GRADES = "Grades";
    // columns.
    public static final String GRADES_ID = "_id";
    public static final String GRADES_NAME = "name";
    public static final String GRADES_GRADE = "grade";
    public static final String GRADES_CREATED = "created";

    public static final String[] GRADES_ALL_COLUMNS = {
            GRADES_ID, GRADES_NAME, GRADES_GRADE, GRADES_CREATED
    };

    // TEXT, INTEGER, NULL, BOOLEAN, REAL(float), BLOB.

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_GRADES + " (" +
            GRADES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            GRADES_NAME + " TEXT, " +
            GRADES_GRADE + " INTEGER, " +
            GRADES_CREATED + " TEXT default CURRENT_TIMESTAMP" +
            ")";


    public DBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_GRADES);
        onCreate(db);
    }
}
