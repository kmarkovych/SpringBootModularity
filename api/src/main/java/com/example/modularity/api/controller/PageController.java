package com.example.modularity.api.controller;

/**
 * Created by Kmarkovych on 19-Jul-16.
 */
public interface PageController {
    /**
     * @return name of page in menu
     */
    String getName();

    /**
     * @return URL for menu item
     */
    String getURL();

    /**
     * @return  order id for menu
     */
    Integer getOrder();
}
