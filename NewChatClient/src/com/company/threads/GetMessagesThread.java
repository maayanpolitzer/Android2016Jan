package com.company.threads;

import com.company.Main;
import com.company.interfaces.SyncListener;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by maayanpolitzer on 07/03/2016.
 */
public class GetMessagesThread extends Thread {

    private volatile boolean sync;
    private SyncListener listener;
    private int numOfMessages;

    public GetMessagesThread(SyncListener listener){
        sync = true;
        this.listener = listener;
        numOfMessages = 0;
    }

    @Override
    public void run() {
        while(sync){
            String[] newMessages = getNewMessages();
            if (newMessages != null && newMessages.length > 0){
                listener.handleNewMessages(newMessages);
            }else{
                System.out.println("no new messages to display");
            }
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String[] getNewMessages(){
        /*
        TODO:
            1. create ArrayList<String> messages.
            2. create a socket, inputStream and outputStream.
            3. get the number of new messages.
            4. send how many messages you have.
            4. while this number is larger then numOfMessages.
            5. store the received messages in the ArrayList && increment numOfMessages.
            6. return the return ArrayList as String[].
         */

        String[] returnedMessages = null;
        OutputStream out = null;
        InputStream in = null;
        try {
            Socket socket = new Socket(Main.IP_ADDRESS, Main.PORT);
            out = socket.getOutputStream();
            in = socket.getInputStream();
            out.write(Main.GET_MESSAGES);
            out.write(numOfMessages);
            //int numOfMessagesInServer = in.read();
            //System.out.println("in server: " + numOfMessagesInServer + ", in client: " + numOfMessages);
            //out.write(numOfMessages);
            int messagesToRead = in.read();
            returnedMessages = new String[messagesToRead];
            for (int i = 0; i < returnedMessages.length; i++){
                int stringLength = in.read();
                System.out.println("String length: " + stringLength);
                byte[] buffer = new byte[stringLength];
                in.read(buffer);
                String s = new String(buffer, 0, stringLength);
                System.out.println(s);
                returnedMessages[i] = s;
                numOfMessages++;
            }
        } catch (IOException e) {
            System.out.println("Problem creating socket object: " + e.getMessage());
        } finally {
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
        }
        return returnedMessages;
    }

    public void shutDown(){
        sync = false;
    }
}
