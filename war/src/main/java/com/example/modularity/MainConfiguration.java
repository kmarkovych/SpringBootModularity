package com.example.modularity;

import com.example.modularity.api.controller.PageController;
import com.example.modularity.controller.ItemController;
import com.example.modularity.controller.MainController;
import com.example.modularity.service.PageControllerPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kmarkovych on 08-Jul-16.
 */
@Configuration
public class MainConfiguration {

    @Bean
    public PageController getMainController() {
        return new MainController();
    }

    @Bean
    public ItemController getItemController() {
        return new ItemController();
    }

    @Bean
    public PageControllerPostProcessor getPageControllerPostProcessor(){
        return new PageControllerPostProcessor();
    }
}
