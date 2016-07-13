package com.example.modularity.api.service;

import com.example.modularity.api.domain.Order;

/**
 * Created by Kmarkovych on 08-Jul-16.
 */
public interface OrderService {
    Order createOrder(String sessionId);
    Order getOrderBySession(String sessionId);
    Order addItem(String sessionId, Long itemId);
    boolean processOrder(String sessionId);
}
