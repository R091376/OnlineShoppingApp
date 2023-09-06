package com.onlineshopping.orderms.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "orders")
@Data
public class Order {
    @Id
    private String id;

    private Long userId;
    private List<OrderItem> items;
    private double totalAmount;
    private String status;

    // Other order attributes

    // Getters and setters
}
