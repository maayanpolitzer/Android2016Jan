package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    public static final int SEND_MESSAGE = 1;
    public static final int GET_MESSAGES = 2;
    private static final int PORT = 14564;
    private static ArrayList<String> messages;

    public static void main(String[] args) {
        messages = new ArrayList<>();
        try {
            ServerSocket server = new ServerSocket(PORT);
            Socket socket = null;
            while(true){
                System.out.println("waiting for connections...");
                socket = server.accept();
                System.out.println("Client connected.");
                ClientThread clientThread = new ClientThread(socket, messages);
                clientThread.start();
            }
        } catch (IOException e) {
            System.out.println("Problem creating server socket object: " + e.getMessage());
        }
    }

    public static synchronized void addMessage(String message){
        messages.add(message);
    }

}
