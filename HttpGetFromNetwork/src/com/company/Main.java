package com.company;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        String search="";

        try {
            URL url = new URL("http://www.morfix.co.il/" + search);
            InputStream in = url.openStream();
            BufferedInputStream buf = new BufferedInputStream(in);
            StringBuilder sb = new StringBuilder();
            int data = 0;
            while((data = buf.read()) != -1){
                sb.append((char)data);
            }
            System.out.println(sb.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
