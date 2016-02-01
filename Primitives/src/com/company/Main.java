package com.company;

public class Main {

    public static void main(String[] args) {

        boolean bool = true;
        byte b = 127;
        short sh = 29888;
        int i = 8000000;
        long lo = 54523423535645636L;
        double rr = 545345.8577;
        float f = 345.5656F;
        char c = 'h';
        String s = "maayan";

        // convert upward:
        i = 512;
        long gf = i;

        // convert downward:

            // casting:
        byte kk = (byte)i;
    //    System.out.println(kk);

        double p = 59.77;
        int n = (int)p;
    //    System.out.println(n);

        char cc = 'r';
        int ff = (int) cc;
        ff -= 32;
        char v = (char)ff;
        System.out.println(v);

        String s2 = "maayan";
        System.out.println(s2.toUpperCase());


        Double newDouble = new Double(p);
        int gfg = newDouble.intValue();
    //    System.out.println(gfg);

    }
}
