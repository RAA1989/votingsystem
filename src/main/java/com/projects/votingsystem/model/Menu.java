package com.projects.votingsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.BatchSize;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "menus")
public class Menu extends BaseEntity {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "menu")
    @NotNull
    @BatchSize(size = 200)
    private List<Meal> meals;

    @Column(name = "date")
    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate date = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    @NotNull
    @JsonIgnore
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
