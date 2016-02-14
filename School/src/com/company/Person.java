package com.company;

/**
 * Created by hackeru on 14/02/2016.
 */
public abstract class Person {

    private String name;
    private String phone;

    public Person(String name, String phone){
        this.name = name;
        this.phone = phone;
    }

    public void notifyBySMS(String message){
        // Real sms sending... (in android)
        System.out.println(message + ": SMS sent to person- " +
                name +" phone: " + phone + ".");
    }

    public abstract void sayWhoYouAre();

    public String getName(){
        return name;
    }

    public String getPhone() {
        return phone;
    }

}
