package com.company;


public class G {

    public static void main(String[] args){
        int a = 1;
        int b = 2;
        mysteryMix(1, 1);
        mysteryMix(a, b);

        System.out.println(a + "," + b);

    }

    public static void mysteryMix(int a, int b){
        a = 2 * a;
        b = a;
    }

}
