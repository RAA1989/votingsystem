package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Menu;
import com.projects.votingsystem.model.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantService {

    Restaurant create(Restaurant restaurant);

    public List<Restaurant> getAll();

    public Map<Restaurant, Menu> getAllEnabledWithMenu();
}
