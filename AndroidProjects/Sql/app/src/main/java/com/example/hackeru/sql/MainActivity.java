package com.example.hackeru.sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertData("Kevin3", 8);

        listView = (ListView) findViewById(R.id.listView);
        Cursor cursor = getContentResolver().query(GradesProvider.CONTENT_URI,
                DBOpenHelper.GRADES_ALL_COLUMNS, null, null, null);
        String[] from = {DBOpenHelper.GRADES_NAME, DBOpenHelper.GRADES_GRADE};
        int[] to = {android.R.id.text1, android.R.id.text2};
        CursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from, to, 0);

        listView.setAdapter(adapter);

    }

    private void insertData(String name, int grade){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.GRADES_NAME, name);
        values.put(DBOpenHelper.GRADES_GRADE, grade);
        getContentResolver().insert(GradesProvider.CONTENT_URI, values);
    }

}
