package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class Main {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        // insert data:
        map.put("Maayan", "abc");
        map.put("Moshe", "1234");
        map.put("Maayan", "1234");
        //print
        System.out.println(map);    // all data.
        System.out.println(map.get("Maayan"));

        System.out.println(map.containsKey("Maayan"));

        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            System.out.println(map.get(key));
        }

        /*
        for(String s : map.keySet()){
            System.out.println(map.get(s));
        }


        */


    }
}
