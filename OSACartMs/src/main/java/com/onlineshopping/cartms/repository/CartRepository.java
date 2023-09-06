package com.onlineshopping.cartms.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineshopping.cartms.model.Cart;

public interface CartRepository extends MongoRepository<Cart, String> {
    // Custom queries can be added here if needed
}
