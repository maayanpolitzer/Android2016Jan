package com.example.hackeru.whatsapp;

import java.util.ArrayList;

/**
 * Created by hackeru on 03/07/2016.
 */
public class Friend {

    private String username;
    private ArrayList<Message> messages;

    public Friend(String username){
        this.username = username;
        messages = new ArrayList<>();
    }

    @Override
    public String toString() {
        return username;
    }

    public void addMessage(Message message){
        messages.add(message);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public String getUsername() {
        return username;
    }
}
