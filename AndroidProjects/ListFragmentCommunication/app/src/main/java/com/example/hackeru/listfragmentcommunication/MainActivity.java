package com.example.hackeru.listfragmentcommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainFragment.Callbacks {

    public static final String NAME = "ldfgndfg";
    private boolean isLandscape = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction().add(
                R.id.activity_main_container_frame_layout, new MainFragment())
                .commit();

        if (findViewById(R.id.activity_main_detail_frame_layout) != null){
            isLandscape = true;
        }

    }

    @Override
    public void onItemClick(String name) {
        Bundle bundle = new Bundle();
        bundle.putString(NAME, name);
        if (isLandscape){
            DetailFragment fragment = new DetailFragment();
            fragment.setArguments(bundle);
            getFragmentManager().beginTransaction().
                    replace(R.id.activity_main_detail_frame_layout, fragment).commit();
        }else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtras(bundle);
            startActivity(intent);
        }

    }
}
