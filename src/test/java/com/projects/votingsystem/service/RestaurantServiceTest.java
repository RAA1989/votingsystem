package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Meal;
import com.projects.votingsystem.model.Menu;
import com.projects.votingsystem.model.Restaurant;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

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
        Map<Restaurant, Menu> map = service.getAllEnabledWithMenu();
        for(Map.Entry<Restaurant,Menu> entry : map.entrySet()){
            System.out.println(entry.getKey().getName());
            for(Meal meal : entry.getValue().getMeals()){
                System.out.println("    " + meal.getName() + " : " + meal.getValue());
            }
        }
    }
}
