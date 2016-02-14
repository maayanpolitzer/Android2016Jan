package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Person[] persons = new Person[3]; // polymorphic array.
        persons[0] = new Teacher("a", "1");
        persons[1] = new Guard("b", "2");
        persons[2] = new Student("c", "3");

        /*
        for (int i = 0; i < teachers.length; i++){
            Teacher t = teachers[i];
            t.notifyBySMS("Fire!!!! Fire!!!! run for your lives...");
        }
        */

        for (Person p : persons){
            String message = "Fire fire!!!!!";
            if (p instanceof Student){
                ((Student)p).callStudent(message);
            }else{
                p.notifyBySMS(message);
            }

        }



    }
}
