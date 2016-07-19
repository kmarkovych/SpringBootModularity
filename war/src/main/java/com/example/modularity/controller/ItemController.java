package com.example.modularity.controller;

import com.example.modularity.api.domain.Item;
import com.example.modularity.api.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Kmarkovych on 13-Jul-16.
 */
@RequestMapping(ItemController.BASE_URL)
public class ItemController {

    protected static final String BASE_URL = "/item";
    @Autowired
    ItemService itemService;

    @RequestMapping(path = {"", "/", "list"}, method = RequestMethod.POST)
    public
    @ResponseBody
    List<Item> getAvailableItems() {
        return itemService.getAvialableItems();
    }

}
