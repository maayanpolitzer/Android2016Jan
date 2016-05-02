package com.example.hackeru.simplelistview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //String[] arr = {"First", "Second", "Third","First", "Second", "Third","First", "Second", "Third","First", "Second", "Third","First", "Second", "Third","First", "Second", "Third","First", "Second", "Third","First", "Second", "Third"};
//    User[] users = {
//            new User("Kevin", "moshe"),
//            new User("Maayan", "123")
//    };
    Country[] countries = {
            new Country("Israel", R.drawable.israel),
            new Country("USA", R.drawable.usa),
            new Country("Sweden", R.drawable.sweden)
    };
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        //ArrayAdapter<User> adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, users);
        //ArrayAdapter<Country> adapter = new ArrayAdapter<Country>(this, R.layout.list_item, countries);   // WON'T WORK!!!
        KevinAdapter adapter = new KevinAdapter(this, R.layout.list_item, countries);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, CountryActivity.class);
        intent.putExtra("COUNTRY", countries[position].getName());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.action_settings:
                Toast.makeText(this, "Settings clicked!", Toast.LENGTH_SHORT).show();
                return true;

        }
        return false;
    }
}
