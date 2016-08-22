package com.example.hackeru.drawinggameclient.threads;

import android.os.Handler;
import android.util.Log;

import com.example.hackeru.drawinggameclient.activities.BaseActivity;
import com.example.hackeru.drawinggameclient.activities.RegisterActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


/**
 * Created by hackeru on 21/08/2016.
 */
public class SendEmailAndPasswordThread extends BaseThread {

    private String email, password;
    private BaseActivity activity;
    private Handler handler;
    private int action;

    public SendEmailAndPasswordThread(String email, String password, BaseActivity activity, int action){
        this.email = email;
        this.password = "," + password;
        this.activity = activity;
        handler = new Handler();
        this.action = action;

    }

    @Override
    public void run() {
        OutputStream out = null;
        InputStream in = null;
        try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);

            out = socket.getOutputStream();
            in = socket.getInputStream();
            out.write(action);
            out.write(email.getBytes());
            out.write(password.getBytes());
            final int ok = in.read();
            Log.d("TAG", "ok: " + ok);
            byte[] buffer = new byte[1024];
            int length = in.read(buffer);
            final String response = new String(buffer, 0, length);
            Log.d("TAG", "TOKEN: " + response);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (ok == 200){
                        activity.registrationComplete(response);
                    }else{
                        activity.registrationError(response);
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
