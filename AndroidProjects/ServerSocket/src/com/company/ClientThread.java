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
    private boolean isMessageToRead;

    public ClientThread(Socket clientSocket){
        this.clientSocket = clientSocket;

    }

    @Override
    public void run() {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = clientSocket.getInputStream();
            out = clientSocket.getOutputStream();
            int action = in.read();
            switch(action){
                case 1:
                    // client wants to send a message.
                    Message message = new Message();
                    message.setFrom(in.read());
                    message.setTo(in.read());
                    byte[] buffer = new byte[1024];
                    int length = in.read(buffer);
                    message.setMessage(new String(buffer, 0, length));
                    Main.messagesList.add(message);
                    System.out.println("Client sent: " + message);
                    break;
                case 2:
                    // client want to get a message
                    int client = in.read();
                    for (Message m : Main.messagesList){
                        if (m.getTo() == client && !m.isRead()){
                            isMessageToRead = true;
                            out.write(1);
                            // send to client
                            out.write(m.getFrom());
                            out.write(m.getMessage().getBytes());
                            // set read to true;
                            m.setRead(true);
                            break;
                        }
                    }
                    if (!isMessageToRead){
                        out.write(0);
                    }

                    break;
            }

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
