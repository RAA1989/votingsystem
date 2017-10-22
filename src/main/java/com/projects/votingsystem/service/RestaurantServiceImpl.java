package com.projects.votingsystem.service;

import com.projects.votingsystem.model.Menu;
import com.projects.votingsystem.model.Restaurant;
import com.projects.votingsystem.repository.DataJpaRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<Restaurant, Menu> getAllEnabledWithMenu(){
        Map<Restaurant, Menu> map = new HashMap<>();
        List<Restaurant> list = repository.getAllEnabled();
        for(Restaurant r : list){
           List<Menu> menuList = r.getMenu();
           map.put(r, menuList.get(menuList.size()-1));
        }
        return map;
    }
}
