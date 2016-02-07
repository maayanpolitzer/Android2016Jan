package com.company;

import java.util.Random;

public class Main {

    private static Animal[] animals = {
            new Animal("lion", false),
            new Animal("snake", false),
            new Animal("dolphin", true),
            new Animal("whale", true),
            new Animal("monkey", false),
            new Animal("girrafe", false),
            new Animal("shark", true)
    };

    public static void main(String[] args) {

        Zoo z1 = new Zoo("Ramat gan", 3, 7);
        for (int i = 0; i < 100; i++){
            z1.addAnimal(animals[generateNumber(animals.length)]);
        }
        z1.getStatus();
    }

    public static int generateNumber(int bound){
        Random r = new Random();
        return r.nextInt(bound);
    }
}
