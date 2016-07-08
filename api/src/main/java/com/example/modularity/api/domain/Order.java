package com.example.modularity.api.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * Information about order
 * Created by Kmarkovych on 08-Jul-16.
 */
public class Order {
    private Long id;
    private String status;
    private List<Item> items = new LinkedList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
