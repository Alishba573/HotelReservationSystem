package com.hotel.reservation;

import java.time.LocalDate;

public class Booking {
    private String bookingId;
    private Customer customer;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalPrice;
    
    public Booking(String bookingId, Customer customer, Room room, 
                   LocalDate checkIn, LocalDate checkOut) {
        if (bookingId == null || bookingId.trim().isEmpty()) {
            throw new IllegalArgumentException("Booking ID cannot be empty!");
        }
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null!");
        }
        if (room == null) {
            throw new IllegalArgumentException("Room cannot be null!");
        }
        if (checkIn.isAfter(checkOut)) {
            throw new IllegalArgumentException("Check-in date must be before check-out!");
        }
        
        this.bookingId = bookingId;
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkIn;
        this.checkOutDate = checkOut;
        
        // Calculate total price
        long days = checkOut.toEpochDay() - checkIn.toEpochDay();
        this.totalPrice = days * room.getPricePerNight();
    }
    
    public boolean makeBooking() {
        return room.bookRoom();
    }
    
    // GETTERS
    public String getBookingId() { return bookingId; }
    public Customer getCustomer() { return customer; }
    public Room getRoom() { return room; }
    public LocalDate getCheckInDate() { return checkInDate; }
    public LocalDate getCheckOutDate() { return checkOutDate; }
    public double getTotalPrice() { return totalPrice; }
}
