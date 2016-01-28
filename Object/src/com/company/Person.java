package com.company;

/**
 * Created by hackeru on 27/01/2016.
 */
public class Person {

    private String name;
    private int id;
    private static int personsCreated = 0;

    public Person(String personName){
        name = personName;
        id = ++personsCreated;
    }

    public static int getPersonsCreated(){
        return personsCreated;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return name + ", id: " + id;
    }
}
