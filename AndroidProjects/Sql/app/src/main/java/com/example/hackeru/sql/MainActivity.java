package com.example.hackeru.sql;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    CursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertData("Kevin3", 8);

        //deleteLine(3);

        listView = (ListView) findViewById(R.id.listView);

        updateList();

        listView.setOnItemClickListener(this);

    }

    private void updateList(){
        Cursor cursor = getContentResolver().query(GradesProvider.CONTENT_URI,
                DBOpenHelper.GRADES_ALL_COLUMNS, null, null, null);
        String[] from = {DBOpenHelper.GRADES_NAME, DBOpenHelper.GRADES_GRADE};
        int[] to = {android.R.id.text1, android.R.id.text2};
        adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from, to, 0);
        listView.setAdapter(adapter);
    }

    private void deleteLine(int id){
        getContentResolver().delete(GradesProvider.CONTENT_URI, DBOpenHelper.GRADES_ID + "=" + id, null);

    }

    private void insertData(String name, int grade){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.GRADES_NAME, name);
        values.put(DBOpenHelper.GRADES_GRADE, grade);
        getContentResolver().insert(GradesProvider.CONTENT_URI, values);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Log.d("MAAYAN", "position: " + position + ", id: " + id);
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("id", (int)id);
        startActivityForResult(intent, 667);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 667){
            if (resultCode == RESULT_OK){
                updateList();
            }
        }
    }
}
