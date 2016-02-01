package com.company;

import java.util.Random;

public class Main {

    public static final int EXTRA_LOTTO = 8; //   {1-8}
    public static final int GENERAL_LOTTO = 36;
    static int[] lotto;

    public static void main(String[] args) {

        int[] myGuess = {3,17,5,7,9,33};
        int myExtra = 6;
        lotto = new int[myGuess.length];
        int lottoExtra = createLottery(EXTRA_LOTTO);
        for(int i = 0; i < lotto.length; i++){
            lotto[i] = createLottery(GENERAL_LOTTO);
        }
        int rightGuesses = check(myGuess, lotto);

        switch(rightGuesses){
            case 3:
            case 4:
                System.out.println("almost....");
                break;
            case 5:
                System.out.println("give away 20 NIS.");
                break;
            case 6:
                System.out.println("JACKPOT!!!!!");
                break;
            default:
                System.out.println("GO BROKE! (" + rightGuesses + ")");
                break;
        }
        printArray();
        System.out.println("the extra nuimber is " + lottoExtra);
        if (checkExtra(myExtra, lottoExtra)){
            System.out.println("you guessed the extra too!!!");
        }
    }

    public static void printArray(){

        for (int i : lotto){
            System.out.print(i + " " );
        }
    }


    public static int check(int[] myGuess, int[] lotto){
        int counter = 0;
        for (int i = 0; i < myGuess.length; i++){
            for (int j = 0; j < lotto.length; j++){
                if (myGuess[i] == lotto[j]){
                    counter++;
                }
            }
        }
        return counter;
    }

    public static boolean checkExtra(int x, int y){
        if (x == y){
            return true;
        }
        return false;
    }

    public static int createLottery(int x){
        Random r = new Random();
        int number = 1 + r.nextInt(x);
        if (checkChoice(number)){   // if true - number is OK.
            return number;
        }else{
            return createLottery(x);
        }
    }

    public static boolean checkChoice(int x){
        for (int i = 0; i < lotto.length; i++){
            if (lotto[i] == x) {
                System.out.println("same number in array");
                return false;
            }
        }
        return true;
    }

}
