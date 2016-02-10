package com.company;

public class Main {

    static int[] arr = {7, -50, 13, 82, -5, 6, -2};

    public static void main(String[] args) {

        System.out.println(largestSum());        // should print 96;
        //ADVANCED:
        int[] largestArray = largestArray();
        for (int i = 0; i < largestArray.length; i++){
            System.out.println(largestArray[i]);
        }

    }
}
