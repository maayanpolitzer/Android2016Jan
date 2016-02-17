package com.company;

import java.util.ArrayList;

/**
 * Created by maayanpolitzer on 17/02/2016.
 */
public class Owner {

    private String name;
    private int id;
    private boolean sendSales;
    private ArrayList<Animal> pets;
    private static int counter = 0;

    public Owner(String name){
        this.name = name;
        id = ++counter;
        sendSales = true;
        pets = new ArrayList<>();
    }

    public void addAnimal(PetKind kind, String name){
        if (kind == PetKind.DOG){
            pets.add(new Dog(name, this));
        }else{
            pets.add(new Cat(name, this));
        }
    }

    public Animal getAnimal(String petName){
        for (Animal pet : pets){
            if (pet.getName().equalsIgnoreCase(petName)){
                return pet;
            }
        }
        return null;
    }

    public boolean removeAnimal(String petName){
        for (Animal pet : pets){
            if (pet.getName() == petName){
                pets.remove(pet);
                System.out.println(petName + " removed!");
                return true;
            }
        }
        System.out.println(petName + " does NOT exists.");
        return false;
    }


    public boolean isSendSales() {
        return sendSales;
    }

    public void removeFromSalesSending() {
        sendSales = false;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public ArrayList<Animal> getPets() {
        return pets;
    }

    public void sendMessage(String message, String vet){

        System.out.println("Dear " + name + ",\n" + message + ".\nDr. " + vet + ".");
    }
}
