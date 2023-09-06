package com.onlineshopping.orderms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineshopping.orderms.model.Order;

public interface OrderRepository extends MongoRepository<Order, String> {
    // Custom queries can be added here if needed
}
