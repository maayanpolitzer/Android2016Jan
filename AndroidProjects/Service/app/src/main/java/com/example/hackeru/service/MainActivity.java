package com.example.hackeru.service;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button startBtn;
    private Button displayBtn;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.startBtn);
        displayBtn = (Button) findViewById(R.id.displayImageBtn);
        imageView = (ImageView) findViewById(R.id.imageView);

        startBtn.setOnClickListener(this);
        displayBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == startBtn) {
            Intent intent = new Intent(this, DownloadService.class);
            intent.putExtra("URL", "https://s-media-cache-ak0.pinimg.com/736x/8a/d0/1f/8ad01fe9c81a663751883dae687bd8e0.jpg");
            startService(intent);
        }else{
            // display the image...
            File f = new File(getFilesDir(), "image2.jpg");
            imageView.setImageURI(Uri.fromFile(f));
        }
    }
}
