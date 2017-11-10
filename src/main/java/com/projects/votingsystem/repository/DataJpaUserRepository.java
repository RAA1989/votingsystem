package com.projects.votingsystem.repository;


import com.projects.votingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface DataJpaUserRepository extends JpaRepository<User, Integer> {

    User getByEmail(String email);
}
