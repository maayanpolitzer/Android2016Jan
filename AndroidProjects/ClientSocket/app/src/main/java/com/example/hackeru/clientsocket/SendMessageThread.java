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
    public static final String SERVER_IP = "10.0.15.49";
    public static final int SERVER_PORT = 10005;
    private int to;

    public SendMessageThread(int to,String message, TextView statusTextView){
        this.message = message;
        this.statusTextView = statusTextView;
        handler = new Handler();
        this.to = to;
    }

    @Override
    public void run() {
        Socket socket = null;
        OutputStream out = null;
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            out = socket.getOutputStream();
            out.write(1);
            out.write(MainActivity.ME);
            out.write(to);
            out.write(message.getBytes());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    statusTextView.setText("Message sent: " + message);
                }
            });
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
