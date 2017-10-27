package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Meal;
import com.projects.votingsystem.repository.DataJpaMealRepository;
import com.projects.votingsystem.repository.DataJpaMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import static com.projects.votingsystem.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealServiceImpl implements MealService{

    @Autowired
    DataJpaMenuRepository menuRepository;

    @Autowired
    DataJpaMealRepository mealRepository;

    @Override
    @Transactional
    public Meal save(Meal meal, int menuId){
        Assert.notNull(meal, "meal must not be null");
        meal.setMenu(menuRepository.getOne(menuId));
        return mealRepository.save(meal);
    }

    @Override
    @Transactional
    public Meal update(Meal meal){
        Assert.notNull(meal, "meal must not be null");
        //meal.setMenu(menuRepository.getOne(menuId));
        return checkNotFoundWithId(mealRepository.save(meal), meal.getId());
    }
}
