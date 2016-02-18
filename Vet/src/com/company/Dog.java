package com.company;

import java.util.Date;

/**
 * Created by hackeru on 17/02/2016.
 */
public class Dog extends Animal {

    private Date lastVaccin;

    public Dog(String name) {
        super(name);
    }

    public Date getLastVaccin(){
        return lastVaccin;
    }

    public void setLastVaccin(Date date){
        this.lastVaccin = date;
    }
}
