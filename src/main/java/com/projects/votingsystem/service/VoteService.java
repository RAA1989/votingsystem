package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Vote;
import com.projects.votingsystem.util.Exception.NotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface VoteService {

    List<Vote> getAllByUser(int userId);

    Vote getLast(int userId);

    List<Vote> getAllByDate(LocalDate date);

    Vote save(Vote vote, int userId, int restaurantId);

    Vote update(Vote vote, int userId, int restaurantId) throws NotFoundException;
}
