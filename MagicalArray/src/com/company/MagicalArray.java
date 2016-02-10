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
        int[] temp = arr;
        arr = new int[counter * 2];
        for (int i = 0; i < temp.length; i++){
            arr[i] = temp[i];
        }
    }

    public int get(int number){
        if (number > -1 && number < counter){
            return arr[number];
        }
        throw new IndexOutOfBoundsException();
    }

    public int size(){
        return counter;
    }

    public void set(int index, int newValue){
        if(index > -1 && index < counter){
            arr[index] = newValue;
        }else{
            throw new IndexOutOfBoundsException();
        }
    }

    public void clear(){
        counter = 0;
        arr = new int[10];
    }

    public boolean isEmpty(){
        return counter == 0;
    }

    public int indexOf(int value){
        for (int i = 0; i < counter; i++){
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(int value){
        for (int i = counter - 1; i >= 0; i--){
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }

    public int[] toArray(){
        int[] newArr = new int[counter];
        for (int i = 0; i < counter; i++){
            newArr[i] = arr[i];
        }
        return newArr;
    }


/*
    public void status(){
        System.out.println("counter: " + counter + ", arr.length: " + arr.length);
    }
    */


}
