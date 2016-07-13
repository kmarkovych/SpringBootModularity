package com.example.modularity.api.domain;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Information about order
 * Created by Kmarkovych on 08-Jul-16.
 */
public class Order implements Serializable {
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

    public static class Status {
        public static final String NEW = "new";
        public static final String IN_PROCESS = "in process";
        public static final String ORDERED = "ordered";
        public static final String CLOSED = "closed";
    }
}
