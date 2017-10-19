package com.projects.votingsystem.service;

import com.projects.votingsystem.model.Restaurant;
import com.projects.votingsystem.repository.DataJpaRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    DataJpaRestaurantRepository repository;

    @Override
    public Restaurant create(Restaurant restaurant){
        Assert.notNull(restaurant, "restaurant must not be null");
        return repository.save(restaurant);
    }
}
