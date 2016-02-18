package com.company;

import java.util.ArrayList;

/**
 * Created by hackeru on 17/02/2016.
 */
public class Vet {

    private String name;
    private int numOfBeds;
    private ArrayList<Customer> petOwners;
    private ArrayList<Animal> hospitalizedAnimals;

    public Vet(String name, int numOfBeds){
        this.name = name;
        this.numOfBeds = numOfBeds;
        petOwners = new ArrayList<>();
        hospitalizedAnimals = new ArrayList<>();
    }

    public void addCustomer(Customer owner){
        petOwners.add(owner);
    }

    public Customer getCustomer(String name){
        for (Customer c : petOwners){
            if (c.getName().equalsIgnoreCase(name)){
                return c;
            }
        }
        return null;
    }

    public void sendSale(String message){
        for (Customer c : petOwners){
            if (c.isSendSale()){
                c.sendMessage(message);
            }
        }
    }

    public void checkVaccin(){
        for (Customer c : petOwners){
            for (Animal a : c.getPets()){
                if (a instanceof Dog){
                    if (((Dog) a).getLastVaccin() == null){
                        c.sendMessage("Come to get vaccin to " + a.getName());
                    }
                }
            }
        }
    }

    public ArrayList<Animal> getHospitalizedAnimals() {
        return hospitalizedAnimals;
    }

    public boolean addAnimalToHospitalize(Animal pet){
        if (hospitalizedAnimals.size() < numOfBeds){
            hospitalizedAnimals.add(pet);
            return true;
        }
        System.out.println("There are NO beds available...");
        return false;
    }


}
