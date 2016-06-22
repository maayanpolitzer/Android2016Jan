package com.example.hackeru.sql;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Created by hackeru on 15/06/2016.
 */
public class GradesProvider extends ContentProvider {

    private static final String AUTHORITY = "com.example.hackeru.sql.gradesprovider";
    private static final String BASE_PATH = "Grades";
    private SQLiteDatabase db;

    // address to the table from in/outside the app.
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH);

    private static final int GRADES = 1;
    private static final int GRADES_ID = 2;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        uriMatcher.addURI(AUTHORITY, BASE_PATH, GRADES);    // retrieve all data...
        uriMatcher.addURI(AUTHORITY, BASE_PATH + "/#", GRADES_ID);  // retrieve one line.
    }


    @Override
    public boolean onCreate() {
        DBOpenHelper helper = new DBOpenHelper(getContext());
        db = helper.getWritableDatabase();
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        if (uriMatcher.match(uri) == GRADES_ID){
            selection = DBOpenHelper.GRADES_ID + "=" + uri.getLastPathSegment();
        }
        return db.query(DBOpenHelper.TABLE_GRADES, DBOpenHelper.GRADES_ALL_COLUMNS, selection,
                null, null, null, DBOpenHelper.GRADES_CREATED + " DESC");
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long id = db.insert(DBOpenHelper.TABLE_GRADES, null, values);
        return Uri.parse(BASE_PATH + "/" + id);
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return db.delete(DBOpenHelper.TABLE_GRADES, selection, selectionArgs);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return db.update(DBOpenHelper.TABLE_GRADES, values, selection, selectionArgs);
    }
}
