package com.company;

public class Main {

    public static void main(String[] args) {

        char[] chars = {'h','e','l','l','o',' ','w','o','r','l','d'};
        MyString s = new MyString(chars);
        System.out.println(s.length());
        s.print();  // hello world
        System.out.println(s.indexOf('m')); //  0;
        System.out.println(s.charAt(6));    //  w;
        System.out.println(s.howManySameChars('l'));    //  3;
        System.out.println(s.contains('k'));    //  false;
        System.out.println(s.isEmpty());    //      false;
        MyString newMyString = s.subString(0,4);   //   MyString newMyString('h','e','l','l','o');
        newMyString.print();
        // ADVANCED:
        char[] c = {'w','o','r','l','d'};
        System.out.println(s.endsWith(c));  //  true;
        System.out.println(s.equals(c));    //  false;
        MyString newMyString2 = s.replace('k', 4);
        newMyString2.print();   //'h','e','l','l','k',' ','w','o','r','l','d'
        //SUPER ADVANCED!!!!!
        MyString[] myStringArray = s.split(' ');
        for (int i = 0; i < myStringArray.length; i++){
            myStringArray[i].print();
        }
    }


}
