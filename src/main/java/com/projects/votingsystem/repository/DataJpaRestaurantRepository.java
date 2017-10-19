package com.projects.votingsystem.repository;

import com.projects.votingsystem.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface DataJpaRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Override
    public Restaurant save(Restaurant item);
}
