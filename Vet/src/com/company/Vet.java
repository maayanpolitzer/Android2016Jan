package com.company;

import java.util.ArrayList;

/**
 * Created by maayanpolitzer on 16/02/2016.
 */
public class Vet {

    private String name;
    private ArrayList<Owner> petOwners;
    private int numOfBeds;
    private ArrayList<Animal> hospitalizedAnimals;

    public Vet(String name, int numOfBeds){
        this.name = name;
        this.numOfBeds = numOfBeds;
        petOwners = new ArrayList<>();
        hospitalizedAnimals = new ArrayList<>();
    }



    public Owner addOwner(Owner newOwner){
        petOwners.add(newOwner);
        return newOwner;
    }

    public Owner getOwner(String name){
        for (Owner owner : petOwners){
            if (owner.getName().equalsIgnoreCase(name)){
                return owner;
            }
        }
        System.out.println("Owner " + name + " does NOT exists.");
        return null;
    }

    public ArrayList<Owner> getOwnerByPetName(String name){
        ArrayList<Owner> owners = new ArrayList<>();
        for (Owner owner : petOwners){
            for (Animal animal : owner.getPets()){
                if (animal.getName().equalsIgnoreCase(name)){
                    owners.add(owner);
                    break;
                }
            }
        }
        return owners;
    }

    public int bedsAvailable(){
        return numOfBeds - hospitalizedAnimals.size();
    }

    public boolean hospitalizeAnimal(Animal animal){
        if (bedsAvailable() > 0){
            hospitalizedAnimals.add(animal);
            return true;
        }
        System.out.println("sorry... no beds available");
        return false;
    }

    public ArrayList<Animal> getHospitalizedAnimals() {
        return hospitalizedAnimals;
    }

    public boolean releaseAnimal(Animal animal){
        if (hospitalizedAnimals.indexOf(animal) > -1){
            hospitalizedAnimals.remove(animal);
            return true;
        }
        System.out.println(animal.getName() + " was NOT hospitalized");
        return false;

    }

    public void sendSale(String message){
        for (Owner owner : petOwners){
            if (owner.isSendSales()){
                owner.sendMessage(message, name);
            }
        }
    }

    public void sendDogVaccinationReminder(){
        String message = "Reminder! get vaccination to your dog!";
        for (Owner owner : petOwners){
            for (Animal animal : owner.getPets()){
                if (animal instanceof Dog){
                    owner.sendMessage(message, name);
                    break;
                }
            }
        }
    }
}
