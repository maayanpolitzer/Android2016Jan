package com.company;

public class Main {

    public static void main(String[] args) {

        drawRect(8, 20);
        drawSquare(20);


    }

    public static void drawRect(int a, int b){
        for (int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                if (j == 0 || j == b-1 || i == 0 || i == a-1){
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void drawSquare(int a){
        drawRect(a,a);
    }


}
