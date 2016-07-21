package com.example.modularity.order.service;

import com.example.modularity.api.domain.Item;
import com.example.modularity.api.domain.Order;
import com.example.modularity.api.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Kmarkovych on 08-Jul-16.
 */
public class MockOrderService implements OrderService {
    protected static final Random RANDOM = new Random();
    final Map<String, Order> orders = new HashMap<>();

    @Autowired
    ItemService itemService;


    @Override
    public Order createOrder(String sessionId) {
        final Order order = new Order();
        order.setId(RANDOM.nextLong());
        order.setStatus(Order.Status.NEW);
        orders.put(sessionId, order);
        return order;
    }

    @Override
    public Order getOrderBySession(String sessionId) {
        Order order = orders.get(sessionId);
        if (order == null) {
            order = createOrder(sessionId);
        }
        return order;
    }

    @Override
    public Order addItem(String sessionId, Long itemId) {
        Order order = getOrderBySession(sessionId);
        order.setStatus(Order.Status.IN_PROCESS);
        final Item item = itemService.getItem(itemId);
        if (item != null) {
            order.getItems().add(item);
            order.setTotal(order.getTotal() + 1);
        }
        return order;
    }

    @Override
    public boolean processOrder(String sessionId) {
        boolean result = false;
        Order order = orders.get(sessionId);
        if (order != null) {
            order.setStatus(Order.Status.ORDERED);
            result = true;
        }
        return result;
    }
}
