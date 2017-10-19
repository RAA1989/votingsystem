package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Menu;

import java.util.List;

public interface MenuService {

    List<Menu> getAllByRestaurant(int restaurantId);

    Menu create(Menu menu, int restaurantId);

    void evictCache();
}
