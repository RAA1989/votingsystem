package com.projects.votingsystem.model;

import java.util.Map;

public class Menu extends BaseEntity {

    private Map<String, Double> items;

    protected Menu(Integer id, Map<String, Double> items) {
        super(id);
        this.items = items;
    }

    public Menu(){
    }

    public Map<String, Double> getItems() {
        return items;
    }

    public void setItems(Map<String, Double> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "items=" + items +
                '}';
    }
}
