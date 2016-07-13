package com.example.modularity.api.domain;

import java.io.Serializable;

/**
 * Order Item
 * Created by Kmarkovych on 08-Jul-16.
 */
public class Item implements Serializable{
    private Long id;
    private String description;

    public Item() {
    }

    public Item(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
