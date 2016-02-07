package com.company;

/**
 * Created by hackeru on 07/02/2016.
 */
public class MagicalArray {

    private int counter;
    private int[] arr;

    public MagicalArray(){
        arr = new int[10];
        counter = 0;
    }

    public boolean add(int x){
        if (arr == null){
            return false;
        }
        if (arr.length == counter){
            makeRoom();
        }
        arr[counter++] = x;
        return true;
    }

    private void makeRoom(){

    }


}
