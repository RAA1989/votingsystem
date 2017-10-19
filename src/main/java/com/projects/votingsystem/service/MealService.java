package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Meal;

public interface MealService {

    Meal save(Meal meal, int menuId);
}
