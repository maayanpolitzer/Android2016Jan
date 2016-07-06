package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static final int MAAYAN = 1;
    public static final int IGOR = 2;
    public static final int REFAEL = 3;
    public static final int RAN = 4;
    public static final int YULIA = 5;

    protected static HashMap<Integer, String> names;

    private static final int PORT = 10005;
    protected static ArrayList<Message> messagesList;

    private static void initMap() {
        names = new HashMap<>();
        names.put(1,"Maayan");
        names.put(2,"Igor");
        names.put(3,"Refael");
        names.put(4,"Ran");
        names.put(5,"Yulia");

    }

    public static void main(String[] args) {

        messagesList = new ArrayList<>();
        initMap();

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("waiting...");
                Socket clientSocket = serverSocket.accept();    // waiting for client to connect..
                System.out.println("client connected!!!");
                new ClientThread(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Port already in use...");
        }

    }


}
