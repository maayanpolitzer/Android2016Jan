package com.company;

/**
 * Created by hackeru on 03/02/2016.
 */
public class Cage {

    private static int counter = 0;
    private int id;
    private boolean pool;
    private int maxCapacity;
    private Animal[] animalsInside;
    private int indicator;

    public Cage(boolean hasPool, int maxCapacity){
        this.pool = hasPool;
        this.maxCapacity = maxCapacity;
        id = counter++;
        animalsInside = new Animal[maxCapacity];
    }

    public Animal[] getAnimalsInside(){
        return animalsInside;
    }

    public void addAnimal(Animal animal){
        animalsInside[indicator] = animal;
        indicator++;
    }

    public boolean isFull(){
        return indicator == maxCapacity;
    }

    public boolean isPool() {
        return pool;
    }

    @Override
    public String toString() {
        String s = "id: " + id;
        if (pool){
            s += "(POOL)";
        }
        for (int i = 0; i < animalsInside.length; i++){
            if (animalsInside[i] != null){
                s += " " + animalsInside[i].getName();
            }
        }
        return s;
    }
}
