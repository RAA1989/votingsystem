package com.projects.votingsystem.service;

import com.projects.votingsystem.model.Meal;
import com.projects.votingsystem.model.Menu;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static com.projects.votingsystem.TestData.RESTAURANT_ID;

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
    public void save() throws Exception {
        Menu menu = menuService.create(new Menu(), RESTAURANT_ID);
        Meal meal1 = new Meal(null, "new meal", 7777);
        Meal meal2 = new Meal(null, "NEW MEAL", 8888);
        mealService.save(meal1, menu.getId());
        mealService.save(meal2, menu.getId());
        List<Menu> list = menuService.getAllByRestaurant(RESTAURANT_ID);
        Menu newMenu = list.get(0);
        for(Meal meal : newMenu.getMeals()){
            System.out.println(meal.getName() + " : " + meal.getValue());
        }
    }

}