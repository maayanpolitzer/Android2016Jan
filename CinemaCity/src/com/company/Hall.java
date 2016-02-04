package com.company;

public class Hall {

    private String movieName;
    private boolean[] chairs;

    public Hall(String movieName, int numOfSeats){
        this.movieName = movieName;
        chairs = new boolean[numOfSeats];
    }

    public boolean buyTicket(){
        for(int i = 0; i < chairs.length; i++){
            if(!chairs[i]){     // same as (chairs[i] == false)
                chairs[i] = true;
                System.out.println("Thanks for buying ticket, place: " + i);
                return true;
            }
        }
        System.out.println("HALL IS FULL!");
        return false;
    }

    public boolean buySpecial(int seat){
        if (checkIfThereIsEmptySeat()){
            if (seat < chairs.length && seat > -1){
                if (!chairs[seat]){
                    chairs[seat] = true;
                    System.out.println("Thanks for buying ticket, place: " + seat);
                    return true;
                }
                System.out.println("seat already taken...");
                return false;
            }
            System.out.println("Are you crazy??????");
            return false;
        }
        System.out.println("hall is full");
        return false;
    }

    public boolean checkIfThereIsEmptySeat(){
        for (int i = 0; i < chairs.length; i++){
            if (!chairs[i]){
                return true;
            }
        }
        return false;
    }

    public void print(){
        for (int i = 0; i < chairs.length; i++){
            if (chairs[i]){
                System.out.print("*");
            }else{
                System.out.print("-");
            }

        }
        System.out.println();
    }
}
