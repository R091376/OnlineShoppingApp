package com.onlineshopping.orderms.service;

import java.util.List;

import com.onlineshopping.orderms.model.Order;
import com.onlineshopping.orderms.model.OrderItem;

public interface OrderService {
    Order createOrder(Long userId, List<OrderItem> items);
    Order getOrderById(String id);
    List<Order> getAllOrders();
}
