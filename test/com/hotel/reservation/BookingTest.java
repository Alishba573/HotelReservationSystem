package com.hotel.reservation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class BookingTest {
    
    @Test
    void testBookingCreation() {
        // Arrange
        Customer customer = new Customer("C001", "Ali", "ali@email.com", "03001234567");
        Room room = new Room(101, "Deluxe", 150.0);
        LocalDate checkIn = LocalDate.of(2024, 1, 15);
        LocalDate checkOut = LocalDate.of(2024, 1, 17);
        
        // Act
        Booking booking = new Booking("B001", customer, room, checkIn, checkOut);
        
        // Assert
        assertEquals("B001", booking.getBookingId());
        assertEquals(customer, booking.getCustomer());
        assertEquals(room, booking.getRoom());
        assertEquals(checkIn, booking.getCheckInDate());
        assertEquals(checkOut, booking.getCheckOutDate());
        assertEquals(300.0, booking.getTotalPrice(), 0.01); // 2 days * 150
    }
    
    @Test
    void testMakeBooking() {
        // Arrange
        Customer customer = new Customer("C001", "Ali", "ali@email.com", "03001234567");
        Room room = new Room(101, "Deluxe", 150.0);
        LocalDate checkIn = LocalDate.now();
        LocalDate checkOut = checkIn.plusDays(2);
        Booking booking = new Booking("B001", customer, room, checkIn, checkOut);
        
        // Act
        boolean bookingResult = booking.makeBooking();
        
        // Assert
        assertTrue(bookingResult);
        assertFalse(room.isAvailable());
    }
    
    @Test
    void testInvalidBookingId() {
        Customer customer = new Customer("C001", "Ali", "ali@email.com", "03001234567");
        Room room = new Room(101, "Deluxe", 150.0);
        LocalDate checkIn = LocalDate.now();
        LocalDate checkOut = checkIn.plusDays(2);
        
        // Test empty booking ID
        assertThrows(IllegalArgumentException.class, 
            () -> new Booking("", customer, room, checkIn, checkOut));
        
        // Test null booking ID
        assertThrows(IllegalArgumentException.class, 
            () -> new Booking(null, customer, room, checkIn, checkOut));
    }
    
    @Test
    void testInvalidDates() {
        Customer customer = new Customer("C001", "Ali", "ali@email.com", "03001234567");
        Room room = new Room(101, "Deluxe", 150.0);
        LocalDate checkIn = LocalDate.of(2024, 1, 17);
        LocalDate checkOut = LocalDate.of(2024, 1, 15); // Earlier than check-in
        
        // Test check-in after check-out
        assertThrows(IllegalArgumentException.class, 
            () -> new Booking("B001", customer, room, checkIn, checkOut));
    }
    
    @Test
    void testNullCustomerOrRoom() {
        Customer customer = new Customer("C001", "Ali", "ali@email.com", "03001234567");
        Room room = new Room(101, "Deluxe", 150.0);
        LocalDate checkIn = LocalDate.now();
        LocalDate checkOut = checkIn.plusDays(2);
        
        // Test null customer
        assertThrows(IllegalArgumentException.class, 
            () -> new Booking("B001", null, room, checkIn, checkOut));
        
        // Test null room
        assertThrows(IllegalArgumentException.class, 
            () -> new Booking("B001", customer, null, checkIn, checkOut));
    }
}
