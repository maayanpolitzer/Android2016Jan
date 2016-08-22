package com.example.hackeru.drawinggameclient.threads;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 21/08/2016.
 */
public class SendImageThread extends BaseThread {

    private File image;

    public SendImageThread(Context context, String fileName){
        image = new File(context.getFilesDir(), fileName);
    }

    @Override
    public void run() {
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            OutputStream out = socket.getOutputStream();
            out.write(ACTION_SEND_IMAGE);
            byte[] buffer = new byte[1024];
            int length;
            FileInputStream in = new FileInputStream(image);
            while((length = in.read(buffer)) > 0){
                out.write(buffer, 0, length);
            }
            Log.d("TAG", "Image sent!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
