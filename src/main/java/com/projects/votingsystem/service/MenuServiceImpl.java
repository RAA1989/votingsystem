package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Menu;
import com.projects.votingsystem.model.Restaurant;
import com.projects.votingsystem.repository.DataJpaMenuRepository;
import com.projects.votingsystem.repository.DataJpaRestaurantRepository;
import com.projects.votingsystem.util.Exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static com.projects.votingsystem.util.ValidationUtil.assureIdConsistent;
import static com.projects.votingsystem.util.ValidationUtil.checkNotFound;
import static com.projects.votingsystem.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MenuServiceImpl implements MenuService{

    private final DataJpaMenuRepository menuRepository;

    @Autowired
    private DataJpaRestaurantRepository restaurantRepository;

    @Autowired
    public MenuServiceImpl(DataJpaMenuRepository repository) {
        this.menuRepository = repository;
    }

    @Override
    @Cacheable("menus")
    public List<Menu> getAllByRestaurant(int restaurantId) {
        return menuRepository.getAllByRestaurant(restaurantId);
    }

    @Override
    @CacheEvict(value = "menus", allEntries = true)
    @Transactional
    public Menu create(int restaurantId) throws NotFoundException{
        Menu menu = new Menu();
        Restaurant restaurant = checkNotFoundWithId(restaurantRepository.findOne(restaurantId), restaurantId);
        menu.setRestaurant(restaurant);
        return menuRepository.save(menu);
    }

    @CacheEvict(value = "menus", allEntries = true)
    @Override
    public void evictCache() {
        // only for evict cache
    }
}
