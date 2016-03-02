package com.company;


import java.util.Date;

public class Main{

    public static void main(String[] args) {

        System.out.println(new Date());
        ClassRoom classRoom = new ClassRoom(5);
        classRoom.getTeacher().startTest();


    }


}
