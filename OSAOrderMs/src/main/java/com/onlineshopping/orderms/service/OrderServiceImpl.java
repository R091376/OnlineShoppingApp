package com.onlineshopping.orderms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineshopping.orderms.feignclient.ProductFeignClient;
import com.onlineshopping.orderms.feignclient.UserFeignClient;
import com.onlineshopping.orderms.model.Order;
import com.onlineshopping.orderms.model.OrderItem;
import com.onlineshopping.orderms.model.Product;
import com.onlineshopping.orderms.model.User;
import com.onlineshopping.orderms.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserFeignClient userFeignClient; // Feign client for inter-service communication with User microservice

    @Autowired
    private ProductFeignClient productFeignClient; // Feign client for inter-service communication with Product microservice

    @Override
    public Order createOrder(Long userId, List<OrderItem> items) {
        // Retrieve user information from the User microservice
        User user = userFeignClient.getUserById(userId);

        if (user != null) {
            // Retrieve product information from the Product microservice for each item
            for (OrderItem item : items) {
                Product product = productFeignClient.getProductById(item.getProductId());
                if (product != null) {
                    item.setProductName(product.getName());
                    item.setPrice(product.getPrice());
                    // Set other product-related attributes
                }
            }

            // Calculate total amount and set other order attributes
            double totalAmount = calculateTotalAmount(items);

            Order order = new Order();
            order.setUserId(userId);
            order.setItems(items);
            order.setTotalAmount(totalAmount);
            order.setStatus("ORDER_RECEIVED");

            return orderRepository.save(order);
        }

        return null; // User not found
    }

    @Override
    public Order getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Implement other methods as needed

    private double calculateTotalAmount(List<OrderItem> items) {
        // Implement logic to calculate the total amount based on order items
        double totalAmount = 0.0;
        for (OrderItem item : items) {
            totalAmount += item.getPrice() * item.getQuantity();
        }
        return totalAmount;
    }
}
