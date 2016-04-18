package com.example.hackeru.listeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    User[] users = {
            new User("kevin", "Kevin garces", true, "Single", R.mipmap.ic_launcher),
            new User("maayan", "Maayan Politzer", false, "married", R.mipmap.ic_launcher),
            new User("Joe", "Joe Alexander", false, "married", R.mipmap.ic_launcher)
    };
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        ArrayAdapter<User> adapter = new ArrayAdapter<User>(this,
                android.R.layout.simple_list_item_1, users);
        listView.setAdapter(adapter);
        //listView.setOnItemClickListener(this);


    }


}
