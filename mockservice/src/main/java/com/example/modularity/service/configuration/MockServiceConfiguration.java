package com.example.modularity.service.configuration;

import com.example.modularity.api.service.ItemService;
import com.example.modularity.service.MockItemService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kmarkovych on 19-Jul-16.
 */
@Configuration
public class MockServiceConfiguration {
    @Bean
    @ConditionalOnMissingBean(ItemService.class)
    public ItemService getItemService() {
        return new MockItemService();
    }

}
