package com.projects.votingsystem.service;

import com.projects.votingsystem.model.Restaurant;
import com.projects.votingsystem.model.Vote;
import com.projects.votingsystem.repository.DataJpaRestaurantRepository;
import com.projects.votingsystem.repository.DataJpaUserRepository;
import com.projects.votingsystem.repository.DataJpaVoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.projects.votingsystem.util.ValidationUtil.checkNotFoundWithId;


@Service
public class VoteServiceImpl implements VoteService {

    private final DataJpaVoteRepository voteRepository;

    @Autowired
    private DataJpaRestaurantRepository restaurantRepository;

    @Autowired
    private DataJpaUserRepository userRepository;


    @Autowired
    public VoteServiceImpl(DataJpaVoteRepository repository) {
        this.voteRepository = repository;
    }

    @Override
    public List<Vote> getAllByUser(int userId) {
        return voteRepository.getAllByUser(userId);
    }

    @Override
    public Vote getLast(int userId) {
        List<Vote> list = voteRepository.getAllByUser(userId);
        return list.get(list.size()-1);
    }


    @Override
    public List<Vote> getAllByDate(LocalDate date) {
        LocalDateTime startDateTime = LocalDateTime.of(date, LocalTime.MIN);
        LocalDateTime endDateTime = LocalDateTime.of(date, LocalTime.MAX);
        return voteRepository.getAllByDateTime(startDateTime,endDateTime);
    }

    @Override
    public Vote save(Vote vote, int userId, int restaurantId) {
        Assert.notNull(vote, "vote must not be null");
        vote.setUser(userRepository.getOne(userId));
        vote.setRestaurant(restaurantRepository.getOne(restaurantId));
        return voteRepository.save(vote);
    }

    @Override
    @Transactional
    public Vote update(Vote vote, int userId, int restaurantId) {
        Assert.notNull(vote, "vote must not be null");
        vote.setUser(userRepository.getOne(userId));
        vote.setRestaurant(restaurantRepository.getOne(restaurantId));
        return checkNotFoundWithId(voteRepository.save(vote), vote.getId());
    }
//
//    @Override
//    public Map<Restaurant, Integer> countVotes(LocalDate date){
//        List<Vote> votes = getAllByDate(date);
//        return votes.stream().collect(Collectors.groupingBy(Vote::getRestaurant, Collectors.summingInt(v -> 1)));
//    }


    @Override
    public Map<Restaurant, List<Vote>> countVotes(LocalDate date){
        List<Vote> votes = getAllByDate(date);
        return votes.stream().collect(Collectors.groupingBy(v -> v.getRestaurant()));
    }
}