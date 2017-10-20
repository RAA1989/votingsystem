package com.projects.votingsystem.service;


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
}
