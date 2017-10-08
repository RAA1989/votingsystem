package com.projects.votingsystem.model;

public class Vote extends BaseEntity{

    private Restaurant restaurant;

    private Menu menu;

    public Vote(){
    }

    public Vote(Integer id, Restaurant restaurant, Menu menu) {
        super(id);
        this.restaurant = restaurant;
        this.menu = menu;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "restaurant=" + restaurant +
                ", menu=" + menu +
                '}';
    }
}
