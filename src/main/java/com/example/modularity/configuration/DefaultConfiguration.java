package com.example.modularity.configuration;

import com.example.modularity.controller.MainController;
import com.example.modularity.controller.OrderController;
import com.example.modularity.service.OrderServiceMock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kmarkovych on 08-Jul-16.
 */
@Configuration
public class DefaultConfiguration {

    @Bean
    public MainController getMainController() {
        return new MainController();
    }

    @Bean
    public OrderController getOrderController() {
        return new OrderController();
    }

    @Bean
    public OrderServiceMock getOrderService(){
        return new OrderServiceMock();
    }
}
