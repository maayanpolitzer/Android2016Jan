package com.company;

/**
 * Created by hackeru on 28/02/2016.
 */
public class Number {

    private int num;
    private Number nextNumber;

    public Number(int num){
        this(num, null);
    }

    public Number(int num, Number nextNumber){
        this.num = num;
        this.nextNumber = nextNumber;
    }


    public int getNum() {
        return num;
    }

    public Number getNextNumber() {
        return nextNumber;
    }

    public void setNextNumber(Number nextNumber) {
        this.nextNumber = nextNumber;
    }
}
