package com.onlineshopping.orderms.model;

import lombok.Data;

@Data
public class Product {
    private Long id; // Unique product identifier
    private String name; // Product name
    private double price; // Product price
    // Other product attributes, if needed

    // Getters and setters
}
