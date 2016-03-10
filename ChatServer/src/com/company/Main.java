package com.company;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static final int PORT = 14564;

    public static void main(String[] args) {

        try{
            ServerSocket server = new ServerSocket(PORT);
            Socket socket = null;
            while(true){
                System.out.println("waiting for connections...");
                socket = server.accept();
                System.out.println("client connected.");
                ClientThread client = new ClientThread(socket);
                client.start();
            }
        }catch(Exception e){

        }

    }
}
