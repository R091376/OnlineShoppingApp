package com.onlineshopping.orderms.model;

import lombok.Data;

@Data
public class User {
    private Long id; // Unique user identifier
    private String username; // User's username
    private String email; // User's email address

    // Other user attributes, if needed

    // Getters and setters
}
