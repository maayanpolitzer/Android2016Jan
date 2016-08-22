package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {

    private static final int SERVER_PORT = 10487;
    public static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            while (true){
                System.out.println("waitng for clients...");
                Socket socket = serverSocket.accept();
                System.out.println("client connected!");
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
