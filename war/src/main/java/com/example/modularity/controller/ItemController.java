package com.example.modularity.controller;

import com.example.modularity.api.domain.Item;
import com.example.modularity.api.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Kmarkovych on 13-Jul-16.
 */
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(path = {"", "/" , "list"})
    public @ResponseBody
    List<Item> getAvailableItems(){
        return itemService.getAvialableItems();
    }
}
