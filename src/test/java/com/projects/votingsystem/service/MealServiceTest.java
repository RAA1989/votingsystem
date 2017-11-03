package com.projects.votingsystem.service;

import com.projects.votingsystem.model.Meal;
import com.projects.votingsystem.model.Menu;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.projects.votingsystem.TestData.*;

public class MealServiceTest extends AbstractServiceTest{

    @Autowired
    private MealService mealService;

    @Autowired
    private MenuService menuService;

    @Before
    public void setUp() throws Exception{
        menuService.evictCache();
    }

    @Test
    public void testSave() throws Exception {
        Menu menu = menuService.create(RESTAURANT_ID);
        mealService.create(MEAL1, menu.getId());
        mealService.create(MEAL2, menu.getId());
        List<Menu> list = menuService.getAllByRestaurant(RESTAURANT_ID);
        Menu newMenu = list.get(0);
        for(Meal meal : newMenu.getMeals()){
            System.out.println(meal.getName() + " : " + meal.getMenu().getId());
        }
    }

    @Test
    public void testUpdate() throws Exception {
        Menu menu = menuService.create(RESTAURANT_ID);
        mealService.create(MEAL1, menu.getId());
        mealService.create(MEAL2, menu.getId());
        MEAL1.setName("Updated Meal");
        Meal updated = mealService.update(MEAL1);
        Assert.assertEquals(updated, MEAL1);
    }

    @Test
    public void testDelete(){
        mealService.delete(MEAL_ID);
    }

    @Test
    public void testGet(){
        Assert.assertEquals(mealService.get(MEAL_ID), MEAL1);
    }

}