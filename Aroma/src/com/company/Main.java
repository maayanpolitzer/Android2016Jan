package com.company;

import java.util.Scanner;

public class Main {

    static Order order;

    public static void main(String[] args) {

        Branch telAvivBranch = new Branch();

        while(telAvivBranch.isOpen()){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to aroma!\nWhat to do?");
            System.out.println("no - new order / view - view orders / exit-close program");
            String action = scanner.nextLine();
            switch (action){
                case "no":
                    order = new Order();
                    createNewOrder();
                    System.out.println("what is your name?");
                    String name = scanner.nextLine();
                    order.setName(name);
                    telAvivBranch.addOrder(order);
                    System.out.println(order.getItems());
                    break;
                case "view":
                    System.out.println(telAvivBranch.getOrders());
                    break;
                case "exit":
                    telAvivBranch.close();
                    break;
                default:
                    System.out.println("WHATTT ?????????????????");
                    break;
            }
        }
        System.out.println("We are closing... see you tomorrow");
    }

    private static void createNewOrder() {
        Scanner scanner = new Scanner(System.in);
        boolean addProduct = true;
        while(addProduct) {
            System.out.println("what do you want to order?");
            System.out.println("ice / pasta / juice / meal / done");
            String product = scanner.nextLine();
            switch (product) {
                case "ice":
                    order.addItem(new MenuItem("Ice coffee", 17, 10));
                    break;
                case "pasta":
                    order.addItem(new MenuItem("Pasta", 68.8, 15));
                    break;
                case "juice":
                    order.addItem(new MenuItem("Juice", 8.9, 5));
                    break;
                case "meal":
                    order.addItem(new MenuItem("Meal", 80, 15));
                    break;
                case "done":
                    addProduct = false;
                    break;
                default:
                    System.out.println("WHATT???");
                    break;
            }
        }
    }
}
