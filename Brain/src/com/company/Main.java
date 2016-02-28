package com.company;


public class Main {

    public static void main(String[] args) {

        Number d = new Number(20);
        Number c = new Number(15, d);
        Number b = new Number(10, c);
        Number a = new Number(5, b);

        d.setNextNumber(c); // create loop...

        hasLoop(a);

    }

    public static boolean hasLoop(Number number){

    }

    public static int loopSize(Number number){

    }

}
