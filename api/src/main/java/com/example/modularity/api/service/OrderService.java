package com.example.modularity.api.service;

import com.example.modularity.api.domain.Order;

/**
 * Created by Kmarkovych on 08-Jul-16.
 */
public interface OrderService {
    Order createOrder();
    Order addItem(Long orderId, Long itemId);
    boolean processOrder(Long orderId);
}
