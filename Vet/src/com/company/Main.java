package com.company;

public class Main {

    public static void main(String[] args) {

        Vet vet = new Vet("Moshe", 5);
        vet.addCustomer(new Customer("Maayan"));
        vet.addCustomer(new Customer("Ronen"));
        vet.getCustomer("MaayAn").addPet(new Dog("Bree"));
        vet.getCustomer("Ronen").addPet(new Dog("Riko"));
        vet.getCustomer("MaayAn").addPet(new Cat("mitzi"));
        //System.out.println(vet.getCustomer("maayan").getPets());
        //vet.sendSale("Sale!!! only for now DOGLY on sale");
        vet.getCustomer("RONEN").removeFromSaleMessages();
        //vet.checkVaccin();
        vet.addAnimalToHospitalize(vet.getCustomer("maaYAn").getPetByName("mitzi"));
        System.out.println(vet.getHospitalizedAnimals());
    }
}
