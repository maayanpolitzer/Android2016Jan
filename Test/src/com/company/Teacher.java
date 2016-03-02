package com.company;

import com.company.interfaces.BeginTestListener;

/**
 * Created by hackeru on 02/03/2016.
 */
public class Teacher {

    BeginTestListener classRoom;

    public Teacher(BeginTestListener classRoom){
        this.classRoom = classRoom;
    }


    public void startTest(){
        classRoom.beginTest();
    }

}
