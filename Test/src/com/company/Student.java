package com.company;

import com.company.interfaces.FinishTestListener;

/**
 * Created by hackeru on 02/03/2016.
 */
public class Student {

    FinishTestListener classRoom;

    public Student(FinishTestListener classRoom){
        this.classRoom = classRoom;
    }

    public void startTest(){
        try {
            Thread.sleep(5000);
        } catch (Exception e) {

        }
        classRoom.finishTest();   //  send to classRoom that student finished the test.
    }

}
