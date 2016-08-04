package com.example.hackeru.tappinggame;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class WallOfFameActivity extends BaseActivity implements AdapterView.OnItemLongClickListener {

    private ListView listView;
    private ScoreAdapter adapter;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_of_fame);

        listView = (ListView) findViewById(R.id.listView);
        database.open();

        cursor = database.query();

        adapter = new ScoreAdapter(this, cursor);

        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(this);
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("TAG", "onLongItem");
        database.delete(id);
        // TODO: update the listView!!!
        cursor = database.query();
        adapter.changeCursor(cursor);
        //adapter.notifyDataSetChanged();
        return true;
    }
}
