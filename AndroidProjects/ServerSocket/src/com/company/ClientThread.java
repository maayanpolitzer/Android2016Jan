package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by hackeru on 06/07/2016.
 */
public class ClientThread extends Thread {

    private Socket clientSocket;

    public ClientThread(Socket clientSocket){
        this.clientSocket = clientSocket;

    }

    @Override
    public void run() {
        InputStream in = null;
        try {
            in = clientSocket.getInputStream();
            Message message = new Message();
            message.setFrom(in.read());
            message.setTo(in.read());
            byte[] buffer = new byte[1024];
            int length = in.read(buffer);
            message.setMessage(new String(buffer, 0, length));
            Main.messagesList.add(message);
            System.out.println("Client sent: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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
