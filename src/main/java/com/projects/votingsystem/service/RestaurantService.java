package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant create(Restaurant restaurant);

    public List<Restaurant> getAll();

    //public List<Restaurant> getAllEnabled();
}
