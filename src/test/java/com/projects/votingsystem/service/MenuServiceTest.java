package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Meal;
import com.projects.votingsystem.model.Menu;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static com.projects.votingsystem.TestData.*;
import static org.hamcrest.CoreMatchers.is;

public class MenuServiceTest extends AbstractServiceTest{

    @Autowired
    private MenuService service;

    @Autowired
    private MenuService menuService;

    @Before
    public void setUp() throws Exception{
        menuService.evictCache();
    }

    @Test
    public void testGetAllByRestaurant(){
        List<Menu> list = service.getAllByRestaurant(RESTAURANT_ID);
        for(Menu menu : list){
            System.out.println("Menu at " + menu.getDate() + ":");
            for(Meal meal : menu.getMeals()){
                System.out.println(meal.getName() + " : " + meal.getValue());
            }
        }
    }

    @Test
    public void testCreate(){
        Menu menu = service.create(RESTAURANT_ID);
        System.out.println(menu.getDate());
    }
}
