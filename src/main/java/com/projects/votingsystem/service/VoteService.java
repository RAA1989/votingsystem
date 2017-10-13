package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Vote;

import java.time.LocalDateTime;
import java.util.List;

public interface VoteService {

    List<Vote> getAllByUser(int userId);

    Vote getLast(int userId);

    List<Vote> getAlByDateTime(LocalDateTime dateTime);

    Vote save(Vote vote);
}
