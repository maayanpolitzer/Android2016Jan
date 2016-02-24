package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created by hackeru on 24/02/2016.
 */
public class Hotel {

    private int singleRoom;
    private int doubleRoom;
    private int twinRoom;
    private Room[] rooms;

    public Hotel(int singleRoom, int doubleRoom, int twinRoom) {
        this.singleRoom = singleRoom;
        this.doubleRoom = doubleRoom;
        this.twinRoom = twinRoom;
        initRooms();
    }

    private void initRooms() {
        rooms = new Room[singleRoom + doubleRoom + twinRoom];
        for (int i = 0; i < rooms.length; i++) {
            if (i < singleRoom) {
                rooms[i] = new SingleRoom();
            } else if (i < singleRoom + doubleRoom) {
                rooms[i] = new DoubleRoom();
            } else {
                rooms[i] = new TwinRoom();
            }
        }
    }

    public boolean orderRoom(String roomType) {
        for (Room r : rooms) {
            if (r.getType() == roomType && !r.isOccupied()) {    // same as isOccupied() == false
                r.saveRoom();
                /*
                r.setOccupied(true);
                */
                System.out.println("thank you, your room number is: " + r.getRoomNumber());
                return true;
            }
        }
        System.out.println("wrong type or no available room");
        return false;
    }

    public int getDoubleBed() {
        return doubleRoom;
    }

    public int getSingleBed() {
        return singleRoom + (twinRoom * 2);
    }

    public String occupiedRatio() {
        // "100%";
        double x = 0;
        for (Room r : rooms) {
            if (r.isOccupied()) {
                x++;
            }
        }
        return Math.round((x * 100) / rooms.length) + "%";
    }

    public void saveDataToFile() {
        int incomes = 0;
        for (Room r : rooms) {
            if (r.isOccupied()) {
                incomes += r.getPrice();
            }
        }
        Date d = new Date();
        String kevin = d + ", incomes: " + incomes;
        // create new file, write content to file.
        File f = new File("Report.txt");
        byte[] kevinBytes = kevin.getBytes();
        try {
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);
            out.write(kevinBytes);
            out.close();
        }catch (Exception e){
            System.out.println("Problem: " + e);
        }


    }

}
