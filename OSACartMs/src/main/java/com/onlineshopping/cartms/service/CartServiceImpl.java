package com.onlineshopping.cartms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshopping.cartms.feignclient.ProductFeignClient;
import com.onlineshopping.cartms.feignclient.UserFeignClient;
import com.onlineshopping.cartms.model.Cart;
import com.onlineshopping.cartms.model.CartItem;
import com.onlineshopping.cartms.model.Product;
import com.onlineshopping.cartms.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private ProductFeignClient productFeignClient; // Feign client for inter-service communication with Product microservice

    @Autowired
    private UserFeignClient userFeignClient; // Feign client for inter-service communication with User microservice


    @Override
    public Cart createCart(Long userId) {
        // Implement logic to create a cart
        Cart cart = new Cart();
        cart.setUserId(userId);
        return cartRepository.save(cart);
    }

    @Override
    public Cart getCartById(String id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart addItemToCart(String cartId, CartItem cartItem) {
    	Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null) {
            
            // Retrieve product information from the Product microservice
            Product product = productFeignClient.getProductById(cartItem.getProductId());

            if (product != null) {
                cartItem.setProductName(product.getName());
                cartItem.setPrice(product.getPrice());
                
                // Set other product-related attributes
                cart.getItems().add(cartItem);
                return cartRepository.save(cart);
            }
        }
        return null; // Cart, product, or user not found
    }

    @Override
    public void removeItemFromCart(String cartId, Long productId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart != null) {
            cart.getItems().removeIf(item -> item.getProductId().equals(productId));
            cartRepository.save(cart);
        }
    }
}
