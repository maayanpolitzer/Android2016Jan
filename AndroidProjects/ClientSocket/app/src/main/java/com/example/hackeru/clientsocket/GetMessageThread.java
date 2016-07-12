package com.example.hackeru.clientsocket;

import android.app.Activity;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 10/07/2016.
 */
public class GetMessageThread extends Thread {

    private ReceivedMessageListener listener;

    public GetMessageThread(ReceivedMessageListener listener){
        this.listener = listener;
    }

    @Override
    public void run() {
        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;
        try {
            socket = new Socket(SendMessageThread.SERVER_IP, SendMessageThread.SERVER_PORT);
            in = socket.getInputStream();
            out = socket.getOutputStream();
            out.write(2);
            out.write(MainActivity.ME);
            int isMessage = in.read();
            if (isMessage == 1) {
                int from = in.read();
                byte[] buffer = new byte[1024];
                int length = in.read(buffer);
                String message = new String(buffer, 0, length);
                Log.d("Maayan", "new message!!! from: " + from + ", content: " + message);
                listener.onMessageArrived(from, message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null){
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
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public interface ReceivedMessageListener {
        void onMessageArrived(int from, String message);
    }

}
