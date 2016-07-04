package com.example.hackeru.whatsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    
    private ListView listView;

    private ArrayList<Friend> friends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFriendsToList();

        listView = (ListView) findViewById(R.id.activity_main_list_view);

        ArrayAdapter<Friend> adapter = new ArrayAdapter<Friend>(this,
                android.R.layout.simple_list_item_1, friends);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ChatActivity.class);
        // send friend id / his messages...
        startActivity(intent);
    }

    private void addFriendsToList(){
        friends = new ArrayList<>();
        friends.add(new Friend("Maayan"));
        friends.add(new Friend("Ran"));
        friends.add(new Friend("Kevin"));
        friends.add(new Friend("Igor"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_main_action_profile:
                Intent intent = new Intent(this, ProfileActivity.class);
                startActivity(intent);
                return true;
        }
        return false;
    }


}
