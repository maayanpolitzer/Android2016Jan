package com.example.hackeru.listeview;

/**
 * Created by hackeru on 17/04/2016.
 */
public class User {

    private String username;
    private String displayName;
    private boolean available;
    private String status;
    private int image;

    public User(String username, String displayName, boolean available, String status, int image){
        this.username = username;
        this.displayName = displayName;
        this.available = available;
        this.status = status;
        this.image = image;
    }

    @Override
    public String toString() {
        return displayName + ", " + status + ", " + username;
    }

    public int getImage() {
        return image;
    }

    public String getUsername() {
        return username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getStatus() {
        return status;
    }
}
