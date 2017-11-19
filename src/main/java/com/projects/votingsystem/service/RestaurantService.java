package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    Restaurant create(Restaurant restaurant);

    List<Restaurant> getAll();

    List<Restaurant> getAllWithLastMenu();
}
