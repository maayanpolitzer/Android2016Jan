package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        /*
        1. create a fruits hashMap with name & price.
        2. change the price of  apple to 29.80.
        3. add VAT (17%) to each price.
        4. print map.
        5. save the map data to text file.
         */

        HashMap<String, Double> fruits = new HashMap<>();
        fruits.put("apple", 10.9);
        fruits.put("banana", 10.0);
        fruits.put("pear", 44.95);
        System.out.println(fruits);
        fruits.put("apple", 33.6);
        System.out.println(fruits);

        for (String key : fruits.keySet()){
            double newPrice = fruits.get(key) * 1.17;
            DecimalFormat df = new DecimalFormat("#.##");
            fruits.put(key, Double.valueOf(df.format(newPrice)));
        }

        String data = fruits.toString();
        File f = new File("text.txt");
        try {
            FileOutputStream out = new FileOutputStream(f);
            byte[] dataInBytes = data.getBytes();
            out.write(dataInBytes);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
