package com.example.hackeru.clientsocket;

import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 06/07/2016.
 */
public class SendMessageThread extends Thread {

    private TextView statusTextView;
    private String message;
    private Handler handler;
    private static final String SERVER_IP = "10.0.15.49";
    private static final int SERVER_PORT = 10005;

    public SendMessageThread(String message, TextView statusTextView){
        this.message = message;
        this.statusTextView = statusTextView;
        handler = new Handler();
    }

    @Override
    public void run() {
        Socket socket = null;
        OutputStream out = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            out = socket.getOutputStream();
            out.write(MainActivity.ME);
            out.write(4);
            out.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("Maayan", "Problem connecting to server");
        } finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
