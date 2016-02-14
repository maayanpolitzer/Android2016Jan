package com.company;

/**
 * Created by hackeru on 14/02/2016.
 */
public class Guard extends Employee {

    public Guard(String name, String phone){
        super(name, phone);
    }

    @Override
    public void notifyBySMS(String message) {
        System.out.println(message + ": SMS sent to guard - " +
                getName() +" phone: " + getPhone() + ".");
    }

    @Override
    public void sayWhoYouAre() {
        System.out.println("I'm a guard");
    }
}
