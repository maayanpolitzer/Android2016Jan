package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by maayanpolitzer on 07/03/2016.
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
        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            int action = in.read();
            switch(action){
                case Main.SEND_MESSAGE:
                    System.out.println("SEND MESSAGE");
                    byte[] buffer = new byte[1024];
                    int length = in.read(buffer);
                    String message = new String(buffer, 0, length);
                    System.out.println(message);
                    Main.addMessage(message + "\n");
                    break;
                case Main.GET_MESSAGES:
                    System.out.println("GET MESSAGES");
                    //Main.addMessage("hello man!");
                    int clientMessages = in.read();
                    int messagesToWrite = messages.size() - clientMessages;
                    out.write(messagesToWrite);
                    for (int i = clientMessages; i < messages.size(); i++){
                        byte[] messageInBytes = messages.get(i).getBytes();
                        out.write(messageInBytes.length);
                        out.write(messageInBytes);
                        System.out.println(messages.get(i) + " was delivered...");
                    }
                    break;
                default:

                    break;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
