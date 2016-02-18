package com.company;

import java.util.ArrayList;

/**
 * Created by hackeru on 17/02/2016.
 */
public class Customer {

    private String name;
    private ArrayList<Animal> pets;
    private boolean sendSale;

    public Customer(String name){
        this.name = name;
        pets = new ArrayList<>();
        sendSale = true;
    }

    public void addPet(Animal pet){
        pets.add(pet);

    }

    public String getName(){
        return name;
    }

    public ArrayList<Animal> getPets(){
        return pets;
    }

    public Animal getPetByName(String name){
        for (Animal a : pets){
            if (a.getName().equalsIgnoreCase(name)){
                return a;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    public void sendMessage(String message){
        System.out.println("Dear " + name + "\n" + message + ".\nDr. moshe");
    }

    public boolean isSendSale() {
        return sendSale;
    }

    public void removeFromSaleMessages() {
        sendSale = false;
    }
}
