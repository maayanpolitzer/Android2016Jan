package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Hall h1 = new Hall("Titanic", 5);
        h1.print();
        h1.buySpecial(3);
        h1.print();
        h1.buyTicket();
        h1.print();


/*
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("What is your name?");
            String name = scanner.nextLine();
            System.out.println(name);
            System.out.println("done!");
        }
*/
    }
}
