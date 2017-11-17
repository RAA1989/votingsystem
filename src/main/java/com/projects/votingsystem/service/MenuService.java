package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Menu;
import com.projects.votingsystem.util.Exception.NotFoundException;

import java.util.List;

public interface MenuService {

    List<Menu> getAllByRestaurant(int restaurantId);

    Menu create(int restaurantId) throws NotFoundException;

    void evictCache();
}
