package com.maayanpolitzer;

/**
 * Created by hackeru on 17/02/2016.
 */
public class Person {

    private String name;
    private Gender gender;
    private Relationship status;

    public Person(String name, Gender gender, Relationship status){
        this.name = name;
        this.gender = gender;
        this.status = status;
    }

}
