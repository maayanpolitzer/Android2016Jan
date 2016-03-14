package com.company;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by hackeru on 09/03/2016.
 */
public class ClientThread extends Thread {

    private Socket socket;
    private ArrayList<String> messages;

    public ClientThread(Socket socket, ArrayList<String> messages){
        this.socket = socket;
        this.messages = messages;
    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try{
            in = socket.getInputStream();
            out = socket.getOutputStream();
            int action = in.read(); // action = 55;
            switch(action){
                case 1:
                    System.out.println("client sending message !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    byte[] buffer = new byte[1024];
                    int length = in.read(buffer);
                    String message = new String(buffer, 0, length);
                    Main.addMessage(message);
                    System.out.println("MESSAGE ARIVED: " + message);
                    break;
                case 55:
                    System.out.println("CHECK MESSAGES!!!");
                    int clientMessages = in.read();
                    int messageToSend = messages.size() - clientMessages;
                    out.write(messageToSend);
                    for (int i = clientMessages; i < messages.size(); i++){
                        byte[] messageInBytes = messages.get(i).getBytes();
                        out.write(messageInBytes);
                    }
                    break;
            }
        }catch(Exception e){
            System.out.println("PROBLEM....");
        }
    }
}
