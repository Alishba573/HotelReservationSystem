package com.hotel.reservation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class HotelTest {
    
    @Test
    void testHotelCreation() {
        // Arrange
        String name = "Grand Plaza";
        String location = "Karachi";
        
        // Act
        Hotel hotel = new Hotel(name, location);
        
        // Assert
        assertEquals(name, hotel.getName());
        assertEquals(location, hotel.getLocation());
        assertTrue(hotel.getRooms().isEmpty());
    }
    
    @Test
    void testAddRoom() {
        // Arrange
        Hotel hotel = new Hotel("Test Hotel", "Test City");
        Room room = new Room(101, "Deluxe", 150.0);
        
        // Act
        hotel.addRoom(room);
        
        // Assert
        assertEquals(1, hotel.getRooms().size());
        assertEquals(room, hotel.getRooms().get(0));
    }
    
    @Test
    void testFindAvailableRooms() {
        // Arrange
        Hotel hotel = new Hotel("Test Hotel", "Test City");
        Room room1 = new Room(101, "Deluxe", 150.0);
        Room room2 = new Room(102, "Standard", 100.0);
        hotel.addRoom(room1);
        hotel.addRoom(room2);
        
        // Book one room
        room1.bookRoom();
        
        // Act
        List<Room> availableRooms = hotel.findAvailableRooms();
        
        // Assert
        assertEquals(1, availableRooms.size());
        assertEquals(room2, availableRooms.get(0));
    }
    
    @Test
    void testHotelInvalidName() {
        // Test empty name
        assertThrows(IllegalArgumentException.class, 
            () -> new Hotel("", "Location"));
        
        // Test null name
        assertThrows(IllegalArgumentException.class, 
            () -> new Hotel(null, "Location"));
    }
}