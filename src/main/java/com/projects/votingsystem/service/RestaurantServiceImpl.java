package com.projects.votingsystem.service;

import com.projects.votingsystem.model.Restaurant;
import com.projects.votingsystem.repository.DataJpaRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    DataJpaRestaurantRepository repository;

    @Override
    public Restaurant create(Restaurant restaurant){
        Assert.notNull(restaurant, "restaurant must not be null");
        return repository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAll(){
        return repository.findAll();
    }

//    @Override
//    public List<Restaurant> getAllEnabled(){
//        //repository.getAllEnabled();
//        return null;
//    }
}
