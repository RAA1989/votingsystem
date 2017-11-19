package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Vote;
import com.projects.votingsystem.to.RestaurantRatingTo;

import java.time.LocalDate;
import java.util.List;

public interface VoteService {

    List<Vote> getAllByUser(int userId);

    Vote getLast(int userId);

    List<Vote> getAllByDate(LocalDate date);

    Vote createOrUpdate(int userId, int restaurantId);

    List<RestaurantRatingTo> countVotes(LocalDate date);
}
