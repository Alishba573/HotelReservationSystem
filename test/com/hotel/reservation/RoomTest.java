package com.hotel.reservation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RoomTest {
    
    @Test
    void testRoomCreation() {
        // Arrange & Act
        Room room = new Room(101, "Deluxe", 150.0);
        
        // Assert
        assertEquals(101, room.getRoomNumber());
        assertEquals("Deluxe", room.getType());
        assertEquals(150.0, room.getPricePerNight(), 0.01);
        assertTrue(room.isAvailable());
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100})
    void testInvalidRoomNumber(int invalidNumber) {
        assertThrows(IllegalArgumentException.class, 
            () -> new Room(invalidNumber, "Standard", 100.0));
    }
    
    @Test
    void testInvalidPrice() {
        assertThrows(IllegalArgumentException.class, 
            () -> new Room(101, "Deluxe", -50.0));
    }
    
    @Test
    void testBookRoomWhenAvailable() {
        // Arrange
        Room room = new Room(101, "Deluxe", 150.0);
        
        // Act
        boolean result = room.bookRoom();
        
        // Assert
        assertTrue(result);
        assertFalse(room.isAvailable());
    }
    
    @Test
    void testBookRoomWhenAlreadyBooked() {
        // Arrange
        Room room = new Room(101, "Deluxe", 150.0);
        room.bookRoom(); // First booking
        
        // Act
        boolean secondAttempt = room.bookRoom();
        
        // Assert
        assertFalse(secondAttempt);
        assertFalse(room.isAvailable());
    }
    
    @Test
    void testCheckOut() {
        // Arrange
        Room room = new Room(101, "Deluxe", 150.0);
        room.bookRoom();
        
        // Act
        room.checkOut();
        
        // Assert
        assertTrue(room.isAvailable());
    }
}
