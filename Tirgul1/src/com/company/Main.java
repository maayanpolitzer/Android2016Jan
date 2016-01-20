package com.company;

public class Main {

    public static void main(String[] args) {
	    System.out.println(distance(7, 10));
        System.out.println(product(3, 3000)); //7 * 10;
        /*
        System.out.println(quatient(7, 10));    //  1
        System.out.println(remainder(7, 10));   //  3 = %;
        System.out.println(power(7, 10));       // 7 baasirit...
        System.out.println(sqrt(49));       //  7
        */

        int i = 5;
        i += 6; //i = i + 6;

    }

    static int distance(int x, int y) {
        if (x == y){
            return 0;
        }
        int counter = 0;
        int small = x;
        int large = y;
        if (x > y){
            small = y;
            large = x;
        }
        while(small + counter < large){
            counter++;
        }
        return counter;
    }

    static int product(int x, int y){
        int small = x;
        int large = y;
        if (x > y){
            small = y;
            large = x;
        }
        int result = 0;
        for(int i = 0; i < small; i++){
            result += large;
        }
        return result;
    }

}
