package com.onlineshopping.cartms.model;

import lombok.Data;

@Data
public class CartItem {
    private Long productId;
    private String productName;
    private int quantity;
    private double price;

    // Getters and setters
}