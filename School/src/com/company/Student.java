package com.company;

/**
 * Created by hackeru on 14/02/2016.
 */
public class Student extends Person {

    public Student(String name, String phone) {
        super(name, phone);
    }

    @Override
    public void sayWhoYouAre() {
        System.out.println("I'm a student");
    }

    public void callStudent(String message){
        System.out.println(message + ": call student: " + getName()
                + ", phone: " + getPhone());
    }


}
