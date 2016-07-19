package com.example.modularity.service;

import com.example.modularity.api.domain.Item;
import com.example.modularity.api.service.ItemService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Kmarkovych on 11-Jul-16.
 */
public class MockItemService implements ItemService {
    private static final Map<Long, Item> ITEMS = new HashMap<Long, Item>(){{
        put(1L, new Item(1L, "Super BBQ"));
        put(2L, new Item(2L, "Very Spicy"));
        put(3L, new Item(3L, "Too Hot"));
        put(4L, new Item(4L, "Sausage"));
        put(5L, new Item(5L, "Cheese Puff"));
        put(6L, new Item(6L, "Prawn"));
        put(7L, new Item(7L, "Seafood"));
        put(8L, new Item(8L, "Cocktail"));
        put(9L, new Item(9L, "BBQ Deluxe"));
    }};
    @Override
    public List<Item> getAvialableItems() {
        return new LinkedList<>(ITEMS.values());
    }

    @Override
    public Item getItem(Long id) {
        return ITEMS.get(id);
    }
}
