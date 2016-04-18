package com.example.hackeru.autocompletetextview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> cities;
    AutoCompleteTextView tv;
    Button addCityBtn;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities = new ArrayList<>();
        cities.add("Herzeliya");
        cities.add("Kfar saba");
        cities.add("Tel aviv");
        cities.add("Eilat");
        cities.add("Haifa");

        tv = (AutoCompleteTextView) findViewById(R.id.autoComplete);
        addCityBtn = (Button) findViewById(R.id.add_city);
        addCityBtn.setOnClickListener(this);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, cities);


        tv.setAdapter(adapter);

        //adapter.add("Ashdod");
        //adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        // TODO: check if city exists in "cities".
        String city = tv.getText().toString().trim();
        if (city.length() > 0){
            String capitalCity = city.substring(0, 1).toUpperCase() + city.substring(1);
            if (!cityInList(capitalCity)){
                adapter.add(capitalCity);
                adapter.notifyDataSetChanged();

            }
        }
        tv.setText("");
        // TODO: if not, add new city to list.
        // TODO: change new city first letter to CAPITAL...

    }

    private boolean cityInList(String city){
        for (String s : cities){
            if (s.equalsIgnoreCase(city)){
                return true;
            }
        }
        cities.add(city);
        return false;
    }
}
