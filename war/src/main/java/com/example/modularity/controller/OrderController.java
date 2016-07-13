package com.example.modularity.controller;

import com.example.modularity.api.domain.Order;
import com.example.modularity.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by Kmarkovych on 08-Jul-16.
 */
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(path = {"", "/"})
    public @ResponseBody
    Order getCurrentOrder(HttpSession session){
        return orderService.getOrderBySession(session.getId());
    }

    @RequestMapping("additem")
    public @ResponseBody
    Order addItem(@RequestParam(value = "itemid") Long itemId, HttpSession session) {
        return orderService.addItem(session.getId(), itemId);
    }

}
