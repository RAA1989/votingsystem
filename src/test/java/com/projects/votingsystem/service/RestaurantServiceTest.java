package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Meal;
import com.projects.votingsystem.model.Restaurant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RestaurantServiceTest extends AbstractServiceTest{

    @Autowired
    RestaurantService service;

    @Test
    public void testGetAll(){
        List<Restaurant> list = service.getAll();
        for(Restaurant restaurant : list){
            System.out.println(restaurant.getName());
        }
    }

    @Test
    public void testGetAllEnabledWithMenu(){
        List<Restaurant> list = service.getAllEnabledWithMenu();
        for(Restaurant restaurant : list){
            System.out.println(restaurant.getName());
            for(Meal meal : restaurant.getMenu().get(0).getMeals()){
                System.out.println("    " + meal.getName() + " : " + meal.getValue());
            }
        }
    }

    @Test
    public void testCreate(){
        Restaurant restaurant = new Restaurant();
        restaurant.setName("New Cafe");
        Restaurant created = service.create(restaurant);
        System.out.println(created.getName() + " | " + created.getId());
    }
}
