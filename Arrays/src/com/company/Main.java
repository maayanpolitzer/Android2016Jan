package com.company;

public class Main {

    public static void main(String[] args) {

        Math.sqrt(4);

        int[] grades = new int[3];
        grades[0] = 55;
        grades[1] = 62;
        grades[2] = 80;
      //  grades[1] = 95;

        System.out.println(grades[2]);

        int moshe = 0;

        for (int i = 0; i < grades.length; i++){
            moshe += grades[i];
        }

        int[] moshe2 = grades;

        System.out.println(moshe / grades.length);

        String[] cities = {"rishon", "herzeliya", "tel aviv", "kfar saba"};
        /*
        for (int i = 0; i < cities.length; i++){
            System.out.println(cities[i]);
        }
        */

        String[] reversed = switch1(cities);
        for (int i = 0; i < reversed.length; i++){
            System.out.println(reversed[i]);
        }



    }

    static String[] switch1(String[] moshe){
        String[] s = new String[moshe.length];
        int j = 0;
        for (int i = moshe.length - 1; i >= 0; i--){
            s[j] = moshe[i];
            j++;
        }

        return s;
    }

}
