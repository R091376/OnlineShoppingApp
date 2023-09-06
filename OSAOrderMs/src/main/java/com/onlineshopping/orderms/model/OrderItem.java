package com.onlineshopping.orderms.model;

import lombok.Data;

@Data
public class OrderItem {
    private Long productId;
    private String productName;
    private int quantity;
    private double price;

    // Getters and setters
}
