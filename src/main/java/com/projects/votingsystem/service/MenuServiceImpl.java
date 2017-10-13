package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Menu;
import com.projects.votingsystem.repository.DataJpaMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    private final DataJpaMenuRepository repository;

    @Autowired
    public MenuServiceImpl(DataJpaMenuRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Menu> getAllByRestaurant(int restaurantId) {
        return repository.getAllByRestaurant(restaurantId);
    }

    @Override
    public Menu create(Menu menu) {
        return repository.save(menu);
    }
}
