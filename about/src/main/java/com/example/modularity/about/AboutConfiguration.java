package com.example.modularity.about;

import com.example.modularity.about.controller.AboutController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Kmarkovych on 19-Jul-16.
 */
@Configuration
public class AboutConfiguration {
    @Bean
    public AboutController getController() {
        return new AboutController();
    }


}
