package com.company;

public class MyString {

    private char[] chars;

    public MyString(char[] chars){
        this.chars = chars;
    }

    public int length(){
        return chars.length;
    }

    public void print(){
        /*
        for (int i = 0; i < chars.length; i++){
            char c = chars[i];
            System.out.print(c);
        }
        */
        for (char c : chars){
            System.out.print(c);
        }
        System.out.println();
    }

    public int indexOf(char x){
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == x){
                return i;
            }
        }
        return -1;
    }

    public char charAt(int x){
        if (x < chars.length && x > 0){
            return chars[x];
        }
        throw new IndexOutOfBoundsException();
    }


}
