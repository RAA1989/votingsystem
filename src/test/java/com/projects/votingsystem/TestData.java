package com.projects.votingsystem;


import com.projects.votingsystem.model.*;

import java.time.LocalDate;
import java.time.Month;

import static com.projects.votingsystem.model.BaseEntity.START_SEQ;

public class TestData {

    public static final int RESTAURANT_ID = START_SEQ + 2;
    public static final int USER1_ID = START_SEQ;
    public static final LocalDate DATE = LocalDate.of(2015, Month.MAY, 31);
    public static final int MEAL_ID = START_SEQ + 12;
    public static final int MENU_ID = START_SEQ + 8;

    public static final Meal MEAL1 = new Meal(100012, "salad", 550);
    public static final Meal MEAL2 = new Meal(100013, "steak", 1600);
    public static final Meal CREATED_MEAL = new Meal(null, "New Meal", 777);
    public static final Meal UPDATED_MEAL = new Meal(null, "Updated Meal", 777);
    public static final Meal FAILED_MEAL = new Meal(null, "N", 50);

    public static final User ADMIN = new User(USER1_ID + 1, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN, Role.ROLE_USER);
    public static final User USER = new User(USER1_ID, "User", "user@yandex.ru", "password", Role.ROLE_USER);

}
