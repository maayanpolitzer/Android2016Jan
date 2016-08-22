package com.example.hackeru.drawinggameclient.threads;

/**
 * Created by hackeru on 21/08/2016.
 */
public class BaseThread extends Thread {

    protected static final String SERVER_IP = "10.0.15.49";
    protected static final int SERVER_PORT = 10487;

    public static final int ACTION_REGISTER = 1;
    public static final int ACTION_LOGIN = 2;
    public static final int ACTION_SEND_IMAGE = 3;


}
