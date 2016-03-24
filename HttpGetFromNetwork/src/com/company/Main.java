package com.company;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        String search="jhjhjhjhjhjhjhjh";
        try {
            URL url = new URL("http://www.morfix.co.il/" + search);
            InputStreamReader in = new InputStreamReader(url.openStream(), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(in);
            String line = "";
            while((line = bufferedReader.readLine()) != null){
                if (line.contains("heTrans")){
                    System.out.println(line);
                    break;
                }
            }
            if (line != null){
                String translate = line.substring(line.indexOf('>') + 1, line.indexOf("</"));
                System.out.println(translate);
            }else{
                System.out.println("no translate");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
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
        */
    }
}
