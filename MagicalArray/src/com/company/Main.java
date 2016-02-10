package com.company;

public class Main {

    public static void main(String[] args) {

        MagicalArray magicalArray = new MagicalArray();
        for (int i = 0; i < 58; i++) {   //  80
            magicalArray.add(i);
        }
        /*
        System.out.println(magicalArray.get(5));    //  5
        System.out.println(magicalArray.size());
        magicalArray.set(28, 7500);
        //       magicalArray.clear();
        System.out.println(magicalArray.isEmpty());
        System.out.println(magicalArray.indexOf(-428));
        System.out.println(magicalArray.lastIndexOf(-428));
        */
        int[] newArr = magicalArray.toArray();
        /*
        System.out.println(newArr.length);
        for (int i : newArr){
            System.out.println(i);
        }

        */
    }
}
