package com.example.hackeru.tappinggame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by hackeru on 03/08/2016.
 */
public class DataSource {
    private SQLiteDatabase db;
    private DBOpenHelper helper;
    private Context context;

    public DataSource(Context context){
        helper = new DBOpenHelper(context);
    }

    public void open(){
        db = helper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public void insert(String name, int score){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COLUMN_NAME, name);
        values.put(DBOpenHelper.COLUMN_SCORE, score);
        db.insert(DBOpenHelper.TABLE_SCORES, null, values);
    }

    public void delete(long id){
        db.delete(
                DBOpenHelper.TABLE_SCORES,
                DBOpenHelper.COLUMN_ID + "=?",
                new String[]{id + ""}
        );
    }

    public Cursor query(){
        return db.query(
                DBOpenHelper.TABLE_SCORES,
                null,
                null,
                null,
                null,
                null,
                DBOpenHelper.COLUMN_SCORE + " DESC",
                null
                );
    }

    public int update(int id, int newScore){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.COLUMN_SCORE, newScore);
        int rowsAffected = db.update(
                DBOpenHelper.TABLE_SCORES,
                values,
                DBOpenHelper.COLUMN_ID + "=?",
                new String[]{id + ""}
        );
        return rowsAffected;
    }
}
