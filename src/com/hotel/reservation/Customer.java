package com.hotel.reservation;

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phone;
    
    public Customer(String customerId, String name, String email, String phone) {
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be empty!");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty!");
        }
        
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    // GETTERS
    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    
  
}
