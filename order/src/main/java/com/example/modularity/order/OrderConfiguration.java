package com.example.modularity.order;

import com.example.modularity.api.controller.PageController;
import com.example.modularity.order.controller.OrderController;
import com.example.modularity.order.service.MockOrderService;
import com.example.modularity.order.service.OrderService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kmarkovych on 19-Jul-16.
 */
@Configuration
public class OrderConfiguration {
    @Bean
    public PageController getOrderController() {
        return new OrderController();
    }

    @Bean
    @ConditionalOnMissingBean(OrderService.class)
    public OrderService getOrderService() {
        return new MockOrderService();
    }



}
