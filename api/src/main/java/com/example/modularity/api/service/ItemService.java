package com.example.modularity.api.service;

import com.example.modularity.api.domain.Item;

import java.util.List;

/**
 * Created by Kmarkovych on 08-Jul-16.
 */
public interface ItemService {
    List<Item> getAvialableItems();
    Item getItem(Long id);
}
