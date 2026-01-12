package com.hotel.reservation;

public class Room {
    private int roomNumber;
    private String type; // "Single", "Double", "Suite"
    private double pricePerNight;
    private boolean isAvailable;
    
    public Room(int roomNumber, String type, double pricePerNight) {
        if (roomNumber <= 0) {
            throw new IllegalArgumentException("Room number must be positive!");
        }
        if (pricePerNight < 0) {
            throw new IllegalArgumentException("Price cannot be negative!");
        }
        
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true; // Rooms are available by default
    }
    
    public boolean bookRoom() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
    
    public void checkOut() {
        isAvailable = true;
    }
    
    // GETTERS
    public int getRoomNumber() { return roomNumber; }
    public String getType() { return type; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return isAvailable; }
}