package com.company;

import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public static final int PORT = 14564;
    public static ArrayList<String> messages;

    public static void main(String[] args) {

        messages = new ArrayList<>();
        try{
            ServerSocket server = new ServerSocket(PORT);
            Socket socket = null;
            while(true){
                System.out.println("waiting for connections...");
                socket = server.accept();
                System.out.println("client connected.");
                ClientThread client = new ClientThread(socket, messages);
                client.start();
            }
        }catch(Exception e){

        }

    }

    public static synchronized void addMessage(String message){
        messages.add(message);
    }
}
