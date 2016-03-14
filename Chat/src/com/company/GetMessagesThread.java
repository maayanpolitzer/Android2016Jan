package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hackeru on 13/03/2016.
 */
public class GetMessagesThread extends Thread {

    private volatile boolean running;
    private int numOfMessage;
    private MessagesListener listener;

    public GetMessagesThread(MessagesListener listener){
        running = true;
        numOfMessage = 0;
        this.listener = listener;
    }

    @Override
    public void run() {
        while(running){
            String[] returnedMessages = checkMessages();
            if (returnedMessages != null && returnedMessages.length > 0){
                listener.handleNewMessages(returnedMessages);
            }
            System.out.println("GET MESSAGES THREAD!");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String[] checkMessages(){
        String[] messagesArray = null;
        try {
            Socket socket = new Socket(Main.IP_ADDRESS, Main.PORT);
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            out.write(55);
            out.write(numOfMessage);
            int messagesToRead = in.read();
            System.out.println("NEED TO READ: " + messagesToRead);
            messagesArray = new String[messagesToRead];
            for (int i = 0; i < messagesToRead; i++){
                byte[] buffer = new byte[1024];
                int length = in.read(buffer);
                String message = new String(buffer, 0, length);
                numOfMessage++;
                messagesArray[i] = message;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return messagesArray;
    }

    public void shutDown(){
        running = false;
    }

}
