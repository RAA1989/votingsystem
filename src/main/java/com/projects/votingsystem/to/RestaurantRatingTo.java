package com.projects.votingsystem.to;


public class RestaurantRatingTo {

    private int id;

    private String name;

    private int rating;

    public RestaurantRatingTo(){}

    public RestaurantRatingTo(int id, String name, int rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    public RestaurantRatingTo(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "RestaurantRatingTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
