package com.company;

import java.io.File;
import java.io.FileOutputStream;

public class Main {

    public static void main(String[] args) {
        /*
        char c = 'R';
        byte r = (byte)c;
        r+= 32;
        char c2 = (char) r;
        System.out.println(c2);
        */

        File f1 = new File("newFile.txt");
        try {
            f1.createNewFile();
            String content = "    *\n   ***\n  *****\n *******";
            FileOutputStream out = new FileOutputStream(f1);
            byte[] textInBytes = transformToByteArray(content);
            //byte[] textInBytes = content.getBytes();
            out.write(textInBytes);
            out.close();
        } catch (Exception e) {
            System.out.println("Crash");
        }

/*
        try {
            String s = getString();
            System.out.println(s.length());
        }catch(Exception e){
            e.printStackTrace();
            // pop alert that "NO internet available...";
        }
        System.out.println("done!");
*/
    }

    public static String getString(){
        return null;
    }

    public static byte[] transformToByteArray(String data){
        byte[] bytes = new byte[data.length()];
        for (int i = 0; i < bytes.length; i++){
            char c = data.charAt(i);
            byte b = (byte) c;
            System.out.println(b);
            bytes[i] = b;
        }
        return bytes;
    }

}
