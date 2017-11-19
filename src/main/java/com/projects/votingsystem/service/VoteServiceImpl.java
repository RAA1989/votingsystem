package com.projects.votingsystem.service;

import com.projects.votingsystem.model.Restaurant;
import com.projects.votingsystem.model.Vote;
import com.projects.votingsystem.repository.DataJpaRestaurantRepository;
import com.projects.votingsystem.repository.DataJpaUserRepository;
import com.projects.votingsystem.repository.DataJpaVoteRepository;
import com.projects.votingsystem.to.RestaurantRatingTo;
import com.projects.votingsystem.util.Exception.TimeOutOfBoundsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.projects.votingsystem.util.RestaurantUtil.votingResultAsTo;


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
        List<Vote> list = getAllByUser(userId);
        if (list.size() == 0) return null;
        return list.get(list.size() - 1);
    }

    @Override
    public List<Vote> getAllByDate(LocalDate date) {
        LocalDateTime startDateTime = LocalDateTime.of(date, LocalTime.MIN);
        LocalDateTime endDateTime = LocalDateTime.of(date, LocalTime.MAX);
        return voteRepository.getAllByDateTime(startDateTime, endDateTime);
    }

    @Override
    @Transactional
    public Vote createOrUpdate(int userId, int restaurantId) {
        Vote voteLast = getLast(userId);
        Vote vote = new Vote();
        if (voteLast != null && voteLast.getDateTime().toLocalDate().isEqual(LocalDate.now())) {
            if (vote.getDateTime().isAfter(LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0)))) {
                throw new TimeOutOfBoundsException("The vote has already been accepted");
            }
            vote = voteLast;
        }
        vote.setUser(userRepository.getOne(userId));
        vote.setRestaurant(restaurantRepository.getOne(restaurantId));
        return voteRepository.save(vote);
    }

    @Override
    @Transactional
    public List<RestaurantRatingTo> countVotes(LocalDate date) {
        List<Vote> votes = getAllByDate(date);
        Map<Restaurant, Integer> map = votes.stream().collect(Collectors.groupingBy(Vote::getRestaurant, Collectors.summingInt(v -> 1)));
        List<Restaurant> restaurants = restaurantRepository.findAll();
        restaurants.stream().filter(r -> !map.containsKey(r)).forEach(r -> map.put(r, 0));
        return votingResultAsTo(map);
    }
}