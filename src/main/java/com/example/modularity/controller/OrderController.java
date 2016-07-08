package com.example.modularity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Kmarkovych on 08-Jul-16.
 */
@RequestMapping("item")
public class OrderController {

    @RequestMapping("add")
    public @ResponseBody
    String addItem(@RequestParam(value = "itemid", required = false, defaultValue = "Some ID") String itemId) {
        return "{\"id\":" + itemId + "}";
    }

}
