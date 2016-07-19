package com.example.modularity.order.configuration;

import com.example.modularity.order.OrderController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kmarkovych on 19-Jul-16.
 */
@Configuration
public class OrderConfiguration {
    @Bean
    public OrderController getOrderController() {
        return new OrderController();
    }

}
