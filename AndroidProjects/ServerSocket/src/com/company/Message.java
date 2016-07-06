package com.company;

import java.util.HashMap;

/**
 * Created by hackeru on 06/07/2016.
 */
public class Message {

    private int from;
    private int to;
    private String message;
    private boolean isRead;

    @Override
    public String toString() {
        return "From: " + Main.names.get(from) + ", to: " + Main.names.get(to) + ",message: " + message;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
