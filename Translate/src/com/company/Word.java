package com.company;

/**
 * Created by hackeru on 20/03/2016.
 */
public class Word {

    private String english;
    private String hebrew;

    public Word(String english, String hebrew){
        this.english = english;
        this.hebrew = hebrew;
    }

    public String getHebrew(){
        return hebrew;
    }

    public String getEnglish(){
        return english;
    }

    @Override
    public String toString(){
        return english + "-" + hebrew;
    }
}
