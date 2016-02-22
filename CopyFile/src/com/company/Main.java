package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        //copyFile();
        deleteFile();

    }

    private static void deleteFile(){
        File f = new File("imageCopy.jpg");
        if (f.exists()){
            f.delete();
        }else{
            System.out.println("no such file...");
        }

    }

    private static void copyFile() {
        FileOutputStream out;
        FileInputStream in;

        File image = new File("car.jpg");
        File newImage = new File("imageCopy.jpg");

        try {
            in = new FileInputStream(image);
            out = new FileOutputStream(newImage);

            byte[] buffer = new byte[1024];     // 1525// 1024// 1025-1525 (500)
            int length; // = 500
            while((length = in.read(buffer)) > 0){
                out.write(buffer, 0, length);   // maayanp163@gmail.com
                System.out.println(length);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
