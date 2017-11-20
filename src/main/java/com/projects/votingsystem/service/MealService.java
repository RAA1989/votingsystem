package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Meal;
import com.projects.votingsystem.util.Exception.NotFoundException;

public interface MealService {

    Meal create(Meal meal, int menuId);

    Meal update(Meal meal, int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    Meal get(int id) throws NotFoundException;
}
