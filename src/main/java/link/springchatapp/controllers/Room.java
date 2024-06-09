package link.springchatapp.controllers;

import java.util.ArrayList;

public class Room {
    private String owner;
    private int roomId;
    private ArrayList<String> chatters;

    public Room(String owner) {
        this.owner = owner;
        roomId = (int) (Math.random() * 100000 + 1000);
        chatters = new ArrayList<String>();
    }

    public String getOwner() {
        return owner;
    }
}
