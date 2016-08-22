package com.company;

import java.util.Random;

/**
 * Created by hackeru on 21/08/2016.
 */
public class User {

    private String email, password, token;
    private static final String OPTIONS = "qwertyuiopasdfghjklzxcvbnm1234567890";

    public User(String email, String password){
        this.email = email;
        this.password = password;
        token = createToken();
    }

    private String createToken(){
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++){
            char c = OPTIONS.charAt(r.nextInt(OPTIONS.length()));
            sb.append(c);
        }
        System.out.println("User: " + email + " get the token : " + sb.toString());
        return sb.toString();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getToken() {
        return token;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }else if (obj == this){
            return true;
        }else{
            User checkUser = (User) obj;
            return email.equals(checkUser.email) && password.equals(checkUser.getPassword());
        }
    }
}
