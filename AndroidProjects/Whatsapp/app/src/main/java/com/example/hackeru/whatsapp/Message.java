package com.example.hackeru.whatsapp;

/**
 * Created by hackeru on 03/07/2016.
 */
public class Message {

    private String body;
    private String from;
    private String to;

    public Message(String from, String to, String body){
        this.from = from;
        this.to = to;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
