package com.hotel.reservation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    
    @Test
    void testCustomerCreation() {
        // Arrange
        String id = "C001";
        String name = "Ali Khan";
        String email = "ali@email.com";
        String phone = "03001234567";
        
        // Act
        Customer customer = new Customer(id, name, email, phone);
        
        // Assert
        assertEquals(id, customer.getCustomerId());
        assertEquals(name, customer.getName());
        assertEquals(email, customer.getEmail());
        assertEquals(phone, customer.getPhone());
    }
    
    @Test
    void testCustomerInvalidId() {
        // Test empty ID
        assertThrows(IllegalArgumentException.class, 
            () -> new Customer("", "Name", "email@test.com", "03001234567"));
        
        // Test null ID
        assertThrows(IllegalArgumentException.class, 
            () -> new Customer(null, "Name", "email@test.com", "03001234567"));
    }
    
    @Test
    void testCustomerInvalidName() {
        // Test empty name
        assertThrows(IllegalArgumentException.class, 
            () -> new Customer("C001", "", "email@test.com", "03001234567"));
        
        // Test null name
        assertThrows(IllegalArgumentException.class, 
            () -> new Customer("C001", null, "email@test.com", "03001234567"));
    }
    
    @Test
    void testCustomerWithNullEmailAndPhone() {
        // Email and phone can be null (not required in our design)
        Customer customer = new Customer("C001", "Ali Khan", null, null);
        assertNull(customer.getEmail());
        assertNull(customer.getPhone());
    }
}