package com.hotel.reservation;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("      HOTEL RESERVATION SYSTEM - CCP DEMO");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        // ==================== CREATE HOTEL ====================
        System.out.println("[USE CASE 1: Hotel Creation]");
        Hotel grandPlaza = new Hotel("Grand Plaza Hotel", "Sea View Road, Karachi");
        System.out.println("✓ Hotel Created: " + grandPlaza.getName());
        System.out.println("  Location: " + grandPlaza.getLocation());
        
        // ==================== ADD ROOMS ====================
        System.out.println("\n[USE CASE 2: Room Management]");
        Room room101 = new Room(101, "Deluxe", 250.0);
        Room room102 = new Room(102, "Standard", 150.0);
        Room room103 = new Room(103, "Suite", 400.0);
        Room room104 = new Room(104, "Deluxe", 250.0);
        
        grandPlaza.addRoom(room101);
        grandPlaza.addRoom(room102);
        grandPlaza.addRoom(room103);
        grandPlaza.addRoom(room104);
        
        System.out.println("✓ Added 4 rooms to hotel:");
        System.out.println("  - Room 101: Deluxe (Rs 250/night)");
        System.out.println("  - Room 102: Standard (Rs 150/night)");
        System.out.println("  - Room 103: Suite (Rs 400/night)");
        System.out.println("  - Room 104: Deluxe (Rs 250/night)");
        
        // ==================== CREATE CUSTOMERS ====================
        System.out.println("\n[USE CASE 3: Customer Registration]");
        Customer ali = new Customer("CUST001", "Ali Ahmed", "ali.ahmed@email.com", "0300-1234567");
        Customer sana = new Customer("CUST002", "Sana Khan", "sana.khan@email.com", "0300-7654321");
        
        System.out.println("✓ Registered 2 customers:");
        System.out.println("  - " + ali.getName() + " (ID: " + ali.getCustomerId() + ")");
        System.out.println("  - " + sana.getName() + " (ID: " + sana.getCustomerId() + ")");
        
        // ==================== CHECK AVAILABILITY ====================
        System.out.println("\n[USE CASE 4: Availability Check]");
        List<Room> availableRooms = grandPlaza.findAvailableRooms();
        System.out.println("✓ Available rooms: " + availableRooms.size() + " out of " + grandPlaza.getRooms().size());
        
        // ==================== MAKE BOOKINGS ====================
        System.out.println("\n[USE CASE 5: Room Booking]");
        LocalDate checkIn = LocalDate.of(2024, 1, 20);
        LocalDate checkOut = LocalDate.of(2024, 1, 25);
        
        Booking booking1 = new Booking("BOOK001", ali, room101, checkIn, checkOut);
        boolean booked1 = booking1.makeBooking();
        
        if (booked1) {
            System.out.println("✓ Booking Successful!");
            System.out.println("  Booking ID: " + booking1.getBookingId());
            System.out.println("  Customer: " + booking1.getCustomer().getName());
            System.out.println("  Room: " + booking1.getRoom().getRoomNumber());
            System.out.println("  Dates: " + booking1.getCheckInDate() + " to " + booking1.getCheckOutDate());
            System.out.println("  Total: Rs " + booking1.getTotalPrice());
        }
        
        // ==================== TRY DOUBLE BOOKING ====================
        System.out.println("\n[USE CASE 6: Prevent Double Booking]");
        Booking booking2 = new Booking("BOOK002", sana, room101, checkIn.plusDays(1), checkOut.plusDays(1));
        boolean booked2 = booking2.makeBooking();
        
        if (!booked2) {
            System.out.println("✗ Booking Failed - Room already booked!");
            System.out.println("  System correctly prevents double booking");
        }
        
        // ==================== CHECK UPDATED AVAILABILITY ====================
        System.out.println("\n[USE CASE 7: Updated Availability]");
        availableRooms = grandPlaza.findAvailableRooms();
        System.out.println("✓ Now available: " + availableRooms.size() + " rooms");
        
        // ==================== SHOW DEFENSIVE PROGRAMMING ====================
        System.out.println("\n[USE CASE 8: Defensive Programming Demo]");
        System.out.println("Testing invalid inputs:");
        
        try {
            Room invalidRoom = new Room(-101, "Test", 100.0);
            System.out.println("✗ Should not reach here - exception expected");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Exception caught: " + e.getMessage());
        }
        
        // ==================== FINAL SUMMARY ====================
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("               DEMO COMPLETED SUCCESSFULLY!");
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("\nSummary:");
        System.out.println("- Hotel: " + grandPlaza.getName());
        System.out.println("- Total Rooms: " + grandPlaza.getRooms().size());
        System.out.println("- Available Rooms: " + availableRooms.size());
        System.out.println("- Active Bookings: 1");
        System.out.println("- System Status: OPERATIONAL ✓");
    }
}
