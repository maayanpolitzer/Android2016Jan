package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Vet vet = new Vet("Moshe", 5);
        vet.addOwner(new Owner("Maayan Politzer"));
        vet.getOwner("Maayan Politzer").addAnimal(PetKind.DOG, "Bree");
        vet.getOwner("maayan politzer").addAnimal(PetKind.CAT, "mitzy");
        vet.addOwner(new Owner("Moshe cohen")).addAnimal(PetKind.DOG, "Bree");
        vet.addOwner(new Owner("Irit Politzer")).addAnimal(PetKind.CAT, "Smelly Cat");
        //System.out.println(vet.getOwnerByPetName("bree"));
        //System.out.println(vet.bedsAvailable());
        vet.hospitalizeAnimal(vet.getOwner("Maayan Politzer").getAnimal("bree"));
        vet.hospitalizeAnimal(vet.getOwner("irit politzer").getAnimal("smelly cat"));
        vet.hospitalizeAnimal(vet.getOwner("moshe Cohen").getAnimal("bree"));
        //System.out.println(vet.getHospitalizedAnimals());
        vet.releaseAnimal(vet.getOwner("maayan politzer").getAnimal("BrEE"));
        /*
        ArrayList<Animal> a = vet.getHospitalizedAnimals();

        for (Animal b : a){
            System.out.println(b.getName() + ", " + b.getOwner());
        }
         */
        //vet.sendDogVaccinationReminder();
        /*
        vet.sendSale("Sale!!! dogly only 4.99$");
        vet.getOwner("maayan politzer").removeFromSalesSending();
        vet.sendSale("Sale!!! dogly only 4.99$");
        */
    }
}
