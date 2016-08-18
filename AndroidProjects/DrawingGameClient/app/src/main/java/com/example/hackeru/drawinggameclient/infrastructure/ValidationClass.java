package com.example.hackeru.drawinggameclient.infrastructure;

/**
 * Created by hackeru on 17/08/2016.
 */
public class ValidationClass {

    public static boolean validate(String email, String pass){
        return !email.isEmpty() && !pass.isEmpty();
    }

    public static boolean validate(String email, String pass, String conPass){
        return validate(email, pass) && pass.equals(conPass);
    }

}
