package com.example.hackeru.simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FlagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageResource(getIntent().getIntExtra("FLAG", 0));

    }
}
