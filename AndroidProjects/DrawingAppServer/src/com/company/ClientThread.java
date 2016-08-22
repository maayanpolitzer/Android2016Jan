package com.company;

import java.io.*;
import java.net.Socket;

/**
 * Created by hackeru on 21/08/2016.
 */
public class ClientThread extends Thread {

    private static final int ACTION_REGISTER = 1;
    private static final int ACTION_LOGIN = 2;
    private static final int ACTION_SEND_IMAGE = 3;
    private static final int OK = 200;
    private static final int ERROR = -1;


    private Socket socket;
    private InputStream in = null;
    private OutputStream out = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            in = socket.getInputStream();
            out = socket.getOutputStream();
            int action = in.read();
            switch (action){
                case ACTION_REGISTER:
                    registerClient();
                    break;

                case ACTION_LOGIN:
                    loginClient();
                    break;

                case ACTION_SEND_IMAGE:
                    File image = new File("image.png");
                    FileOutputStream out = new FileOutputStream(image);
                    byte[] buffer = new byte[1024];
                    int length = 0;
                    while((length = in.read(buffer)) > 0){
                        out.write(buffer, 0, length);
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

    private void loginClient() {
        byte[] buffer = new byte[1024];
        int length = 0;
        try {
            length = in.read(buffer);
            System.out.println("Length: " + length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = new String(buffer, 0, length);
        String[] arr = str.split(",");
        String email = arr[0];
        String password = arr[1];
        System.out.println(email + ", " + password);
        User user = new User(email, password);
        String token = userExists(user);

        if (token != null){
            try {
                out.write(OK);
                out.write(token.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            try {
                out.write(ERROR);
                out.write("user does\'nt exists".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String userExists(User checkUser){
        for (User user : Main.users){
            if (user.equals(checkUser)){
                return user.getToken();
            }
        }
        return null;
    }

    private void registerClient(){
        byte[] buffer = new byte[1024];
        int length = 0;
        try {
            length = in.read(buffer);
            System.out.println("Length: " + length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = new String(buffer, 0, length);
        String[] arr = str.split(",");
        String email = arr[0];
        String password = arr[1];
        System.out.println(email + ", " + password);
        try {
            out.write(checkEmail(email) ? OK : ERROR);
            User user = new User(email, password);
            if (checkEmail(email)) {
                Main.users.add(user);
            }
            System.out.println("User token: " + user.getToken());
            out.write(user.getToken().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkEmail(String email){
        for (User user : Main.users){
            if (user.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }


    private String createString() {
        try {
            byte[] buffer = new byte[1024];
            int length = in.read(buffer);
            return new String(buffer, 0, length);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
