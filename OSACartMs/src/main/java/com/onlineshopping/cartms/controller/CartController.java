package com.onlineshopping.cartms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshopping.cartms.model.Cart;
import com.onlineshopping.cartms.model.CartItem;
import com.onlineshopping.cartms.service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public Cart createCart(@RequestParam Long userId) {
        return cartService.createCart(userId);
    }

    @GetMapping("/{id}")
    public Cart getCartById(@PathVariable String id) {
        return cartService.getCartById(id);
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @PostMapping("/{cartId}/items")
    public Cart addItemToCart(@PathVariable String cartId, @RequestBody CartItem cartItem) {
        return cartService.addItemToCart(cartId, cartItem);
    }

    @DeleteMapping("/{cartId}/items/{productId}")
    public void removeItemFromCart(@PathVariable String cartId, @PathVariable Long productId) {
        cartService.removeItemFromCart(cartId, productId);
    }
}
