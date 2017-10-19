package com.projects.votingsystem.repository;


import com.projects.votingsystem.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface DataJpaMealRepository extends JpaRepository<Meal, Integer> {

    @Override
    Meal save(Meal item);
}
