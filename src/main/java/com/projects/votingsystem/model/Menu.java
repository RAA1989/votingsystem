package com.projects.votingsystem.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "menus")
public class Menu extends BaseEntity {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    private List<Meal> meals;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    @NotNull
    private Restaurant restaurant;

    protected Menu(Integer id, List<Meal> meals, LocalDate date, Restaurant restaurant) {
        super(id);
        this.meals = meals;
        this.date = date;
        this.restaurant = restaurant;
    }

    public Menu(){
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "meals=" + meals +
                ", date=" + date +
                ", restaurant=" + restaurant +
                '}';
    }
}