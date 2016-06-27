package com.example.hackeru.fragments2;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment fragment = new MainFragment();

        getFragmentManager().beginTransaction().add(R.id.container, fragment).commit();   // add the first fragment
        //getFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit(); // replace a fragment

        RadioGroup group = (RadioGroup) findViewById(R.id.group);

        group.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        Fragment fragment;
        if (checkedId == R.id.main){
            fragment = new MainFragment();
        }else{
            fragment = new SecondFragment();
        }
        getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}
