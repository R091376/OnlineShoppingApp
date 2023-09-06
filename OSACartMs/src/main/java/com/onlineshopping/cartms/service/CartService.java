package com.onlineshopping.cartms.service;

import java.util.List;

import com.onlineshopping.cartms.model.Cart;
import com.onlineshopping.cartms.model.CartItem;

public interface CartService {
    Cart createCart(Long userId);
    Cart getCartById(String id);
    List<Cart> getAllCarts();
    Cart addItemToCart(String cartId, CartItem cartItem);
    void removeItemFromCart(String cartId, Long productId);
}
