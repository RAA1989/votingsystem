package com.projects.votingsystem;


import com.projects.votingsystem.model.Vote;

import java.time.LocalDateTime;

import static com.projects.votingsystem.model.BaseEntity.START_SEQ;

public class VoteTestData {

    public static final int VOTE1_ID = START_SEQ + 6;
    public static final int RESTAURANT_ID = START_SEQ + 2;

    public static final Vote VOTE1 = new Vote(START_SEQ, LocalDateTime.of(2015,5,30,10,0));
    public static final Vote VOTE2 = new Vote(VOTE1_ID + 1, LocalDateTime.of(2017,10,25,15,0));

}
