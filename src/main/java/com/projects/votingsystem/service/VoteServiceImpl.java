package com.projects.votingsystem.service;

import com.projects.votingsystem.model.Restaurant;
import com.projects.votingsystem.model.User;
import com.projects.votingsystem.model.Vote;
import com.projects.votingsystem.repository.DataJpaVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class VoteServiceImpl implements VoteService {

    private final DataJpaVoteRepository repository;

    @Autowired
    public VoteServiceImpl(DataJpaVoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Vote> getAllByUser(int userId) {
        return repository.getAllByUser(userId);
    }

    @Override
    public Vote getLast(int userId) {
        List<Vote> list = repository.getAllByUser(userId);
        return list.get(list.size()-1);
    }


    @Override
    public List<Vote> getAllByDate(LocalDate date) {
        LocalDateTime startDateTime = LocalDateTime.of(date, LocalTime.MIN);
        LocalDateTime endDateTime = LocalDateTime.of(date, LocalTime.MAX);
        return repository.getAllByDateTime(startDateTime,endDateTime);
    }

    @Override
    public Vote save(Vote vote, int userId, int restaurantId) {
        User user = new User();
        user.setId(userId);
        Restaurant restaurant = new Restaurant();
        restaurant.setId(restaurantId);
        vote.setUser(user);
        vote.setRestaurant(restaurant);
        return repository.save(vote);
    }
}
