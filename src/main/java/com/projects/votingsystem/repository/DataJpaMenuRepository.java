package com.projects.votingsystem.repository;


import com.projects.votingsystem.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface DataJpaMenuRepository extends JpaRepository<Menu, Integer> {

    @Query("SELECT m FROM Menu m WHERE m.restaurant.id=:restaurantId ORDER BY m.date")
    List<Menu> getAllByRestaurant(@Param("restaurantId") int restaurantId);

    @Override
    Menu save(Menu item);
}
