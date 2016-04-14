package com.example.hackeru.getresultsfromactivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int BACK_FROM_NAME_ACTIVITY_REQUEST_CODE = 1;
    public static final int BACK_FROM_GALLERY_REQUEST_CODE = 2;
    TextView welcome;
    Button addNameBtn, switchBtn;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcome = (TextView) findViewById(R.id.activity_main_name_text_view);
        addNameBtn = (Button) findViewById(R.id.activity_main_addName_button);
        addNameBtn.setOnClickListener(this);
        switchBtn = (Button) findViewById(R.id.activity_main_switch_image_button);
        switchBtn.setOnClickListener(this);
        image = (ImageView) findViewById(R.id.activity_main_image_view);

    }

    @Override
    public void onClick(View v) {
        if (v == addNameBtn){
            Intent intent = new Intent(this, NameActivity.class);
            startActivityForResult(intent, BACK_FROM_NAME_ACTIVITY_REQUEST_CODE);
        }else if(v == switchBtn){
            /*
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            */
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, BACK_FROM_GALLERY_REQUEST_CODE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch(requestCode){
            case BACK_FROM_NAME_ACTIVITY_REQUEST_CODE:
                if (resultCode == RESULT_OK){
                    String name = data.getStringExtra("Name");
                    welcome.setText("welcome " + name);
                }else if(resultCode == RESULT_CANCELED){
                    welcome.setText("back");
                }else{
                    welcome.setText("NO WAY DUDE!!!");
                }
                break;
            case BACK_FROM_GALLERY_REQUEST_CODE:
                /*
                Uri imageUri = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                    image.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                */
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                image.setImageBitmap(imageBitmap);

                break;
        }
    }
}
