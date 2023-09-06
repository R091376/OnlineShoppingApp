package com.onlineshopping.cartms.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "carts")
@Data
public class Cart {
    @Id
    private String id;

    private Long userId;

    private List<CartItem> items = new ArrayList<>();

    // Other cart attributes

    // Getters and setters
}
