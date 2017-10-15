package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Meal;
import com.projects.votingsystem.model.Menu;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static com.projects.votingsystem.VoteTestData.*;
import static org.hamcrest.CoreMatchers.is;

public class MenuServiceTest extends AbstractServiceTest{

    @Autowired
    private MenuService service;

    @Test
    public void testGetAllByRestaurant(){
        List<Menu> list = service.getAllByRestaurant(RESTAURANT_ID);
//        for(Menu menu : list){
//            System.out.println("Menu at " + menu.getDate() + ":");
//            for(Meal meal : menu.getMeals()){
//                System.out.println(meal.getName() + " : " + meal.getValue());
//            }
//        }
        List<Meal> mealList1 = Arrays.asList(MEAL1, MEAL2);
        List<Meal> mealList2 = Arrays.asList(MEAL3, MEAL4);
        Menu testMenu1 = new Menu();
        Menu testMenu2 = new Menu();
        testMenu1.setMeals(mealList1);
        testMenu2.setMeals(mealList2);
        List<Menu> menuList = Arrays.asList(testMenu1,testMenu2);

//        Assert.assertThat(menuList, is(list));
        Assert.assertEquals(list,menuList);
    }
}
