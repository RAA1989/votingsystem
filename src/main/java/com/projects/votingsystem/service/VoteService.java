package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Restaurant;
import com.projects.votingsystem.model.Vote;
import com.projects.votingsystem.util.Exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface VoteService {

    List<Vote> getAllByUser(int userId);

    Vote getLast(int userId);

    List<Vote> getAllByDate(LocalDate date);

    Vote save(Vote vote, int userId, int restaurantId);

    Vote update(Vote vote, int userId, int restaurantId) throws NotFoundException;

    public Map<Restaurant, Integer> countVotes(LocalDate date);
}
