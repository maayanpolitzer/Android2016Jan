package com.company;

/**
 * Created by hackeru on 03/02/2016.
 */
public class Zoo {

    private Cage[] cages;
    private int numOfAnimals;
    private String name;

    public Zoo(String name, int cagesWithPool, int cagesWithoutPool){
        this.name = name;
        initCages(cagesWithPool, cagesWithoutPool);
    }

    public boolean addAnimal(Animal animal){
        for (int i = 0; i < cages.length; i++){
            if (animal.isAquatic() == cages[i].isPool() && !cages[i].isFull() &&
                    (cages[i].getAnimalsInside()[0] == null || cages[i].getAnimalsInside()[0].getName() == animal.getName())){
                cages[i].addAnimal(animal);
                numOfAnimals++;
                return true;
            }
        }
        System.out.println("there is NO place for " + animal.getName());
        return false;
    }

    private void initCages(int cagesWithPool, int cagesWithoutPool) {
        cages = new Cage[cagesWithoutPool + cagesWithPool];
        for (int i = 0; i < cages.length; i++){
            cages[i] = new Cage(i < cagesWithPool ? true : false, 10);
            /*
            if (i < cagesWithPool){
                cages[i] = new Cage(true, 10);
            }else{
                cages[i] = new Cage(false, 10);
            }
            */
        }
    }

    public void getStatus(){
        for (int i = 0; i < cages.length; i++){
            System.out.println(cages[i]);
        }
    }

}
