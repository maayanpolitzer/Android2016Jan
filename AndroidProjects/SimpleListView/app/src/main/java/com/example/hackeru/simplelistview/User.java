package com.example.hackeru.simplelistview;

/**
 * Created by hackeru on 01/05/2016.
 */
public class User {

    private String name;
    private String password;

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return name + " password: " + password;
    }
}
