package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Menu;
import com.projects.votingsystem.model.Restaurant;
import com.projects.votingsystem.repository.DataJpaMenuRepository;
import com.projects.votingsystem.repository.DataJpaRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

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
    public Menu create(Menu menu, int restaurantId) {
        Assert.notNull(menu, "menu must not be null");
        menu.setRestaurant(restaurantRepository.getOne(restaurantId));
        return menuRepository.save(menu);
    }

    @CacheEvict(value = "menus", allEntries = true)
    @Override
    public void evictCache() {
        // only for evict cache
    }
}
