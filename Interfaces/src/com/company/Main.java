package com.company;

public class Main {

    public static void main(String[] args) {

        Dog d = new Dog();
        d.drink();
        d.eat();

        Animal a = new Animal(){

        };

        Eat e2 = new Dog();
        Dog d2 = new Dog();
        Animal d3 = new Dog();

        Eat ee = new Eat(){
            @Override
            public void eat() {

            }

            @Override
            public void drink() {

            }
        };

        ee.eat();

    }
}
