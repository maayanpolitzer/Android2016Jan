package com.company;

/**
 * Created by hackeru on 14/02/2016.
 */
public class Teacher extends Employee {

    public Teacher(String name, String phone){
        super(name, phone);
    }

    @Override
    public void notifyBySMS(String message) {
        System.out.println(message + ": SMS sent to teacher - " +
                getName() +" phone: " + getPhone() + ".");
    }

    @Override
    public void sayWhoYouAre() {
        System.out.println("I'm a teacher");
    }


}
