package com.projects.votingsystem;


import com.projects.votingsystem.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static com.projects.votingsystem.model.BaseEntity.START_SEQ;

public class TestData {

    public static final int VOTE1_ID = START_SEQ + 4;
    public static final int RESTAURANT_ID = START_SEQ + 2;
    public static final int USER1_ID = START_SEQ;
    public static final LocalDate DATE = LocalDate.of(2015, Month.MAY, 31);

    public static final Vote VOTE1 = new Vote(START_SEQ, LocalDateTime.of(2015,5,30,10,0));
    public static final Vote VOTE2 = new Vote(VOTE1_ID + 1, LocalDateTime.of(2017,10,25,15,0));

    public static final Meal MEAL1 = new Meal(100012, "salad", 550);
    public static final Meal MEAL2 = new Meal(100013, "steak", 1600);
    public static final Meal MEAL3 = new Meal(100014, "soup", 600);
    public static final Meal MEAL4 = new Meal(100015, "coffee", 340);

    static {
        Menu menu1 = new Menu();
        Menu menu2 = new Menu();
        menu1.setId(100008);
        menu2.setId(100009);

        MEAL1.setMenu(menu1);
        MEAL2.setMenu(menu1);
        MEAL3.setMenu(menu2);
        MEAL4.setMenu(menu2);
    }

    public static Vote getUpdated(){
        return new Vote(VOTE1_ID, LocalDateTime.of(2017,6,30,10,0));
    }
}
