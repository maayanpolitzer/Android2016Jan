package com.example.hackeru.service;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hackeru on 13/07/2016.
 */
public class DownloadService extends Service {

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                downloadImage(intent.getStringExtra("URL"));
            }
        }).start();

        /*
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(DownloadService.this, "from service", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        }).start();
        */
        return START_NOT_STICKY;
    }

    private void downloadImage(String link){
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            File f = new File(getFilesDir(), "image2.jpg");
            FileOutputStream out = new FileOutputStream(f);
            int length;
            byte[] buffer = new byte[1024];
            while((length = in.read(buffer)) > 0){
                out.write(buffer, 0, length);
            }
            Log.d("Maayan", "download completed");
            sendBroadcast(new Intent("99fm"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
