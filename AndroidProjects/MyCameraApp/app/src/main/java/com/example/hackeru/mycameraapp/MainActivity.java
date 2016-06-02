package com.example.hackeru.mycameraapp;


import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private Camera camera;
    private FrameLayout preview;
    private CameraPreview mPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

    }

    @Override
    protected void onResume() {
        super.onResume();
        camera = getCamera();
        mPreview = new CameraPreview(this, camera);
        preview = (FrameLayout) findViewById(R.id.frameLayout);
        preview.addView(mPreview);
    }

    @Override
    protected void onPause() {
        super.onPause();
        camera.release();
    }

    private Camera getCamera(){
        Camera c = null;
        c = Camera.open();
        return c;
    }
}
