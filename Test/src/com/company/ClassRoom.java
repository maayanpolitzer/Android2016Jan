package com.company;

import com.company.interfaces.BeginTestListener;
import com.company.interfaces.FinishTestListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * Created by hackeru on 02/03/2016.
 */
public class ClassRoom implements BeginTestListener, FinishTestListener{

    private Student[] students;
    private Teacher teacher;
    private int gradesSum;
    private int studensFinished;

    public ClassRoom(int numOfStudents){
        students = new Student[numOfStudents];
        teacher = new Teacher(this);
        initStudents();
    }

    private void initStudents() {
        for (int i = 0; i < students.length; i++){
            students[i] = new Student(this);
        }
    }

    @Override
    public void beginTest(){
        for (Student student : students){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    student.startTest();
                }
            });
            t.start();
        }
    }




    public void allFinished(){
        double average = gradesSum / students.length;
        File f = new File("report.txt");
        try {
            FileOutputStream out = new FileOutputStream(f);
            out.write(new String(new Date() + " : the average is " + average).getBytes());
            out.close();
            System.out.println(new Date());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public void finishTest() {

        gradesSum += new Random().nextInt(101);
        studensFinished++;
        if (studensFinished == students.length){
            allFinished();
        }

        System.out.println(" i just finished!!!");
    }
}
