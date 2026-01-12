package com.hotel.reservation;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private String location;
    private List<Room> rooms;
    
    public Hotel(String name, String location) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Hotel name cannot be empty!");
        }
        this.name = name;
        this.location = location;
        this.rooms = new ArrayList<>();
    }
    
    public void addRoom(Room room) {
        if (room == null) {
            throw new IllegalArgumentException("Room cannot be null!");
        }
        rooms.add(room);
    }
    
    public List<Room> findAvailableRooms() {
        List<Room> available = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                available.add(room);
            }
        }
        return available;
    }
    
    // GETTERS
    public String getName() { return name; }
    public String getLocation() { return location; }
    public List<Room> getRooms() { return rooms; }
}
