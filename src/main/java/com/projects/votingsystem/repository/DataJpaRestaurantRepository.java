package com.projects.votingsystem.repository;

import com.projects.votingsystem.model.Restaurant;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
public interface DataJpaRestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Override
    Restaurant save(Restaurant item);

    @Override
    List<Restaurant> findAll();

    @EntityGraph(attributePaths = "menu", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT r From Restaurant r")
    List<Restaurant> getAllWithLastMenu();
}

