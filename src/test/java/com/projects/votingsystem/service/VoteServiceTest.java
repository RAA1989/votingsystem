package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Vote;
import com.projects.votingsystem.to.RestaurantRatingTo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.projects.votingsystem.TestData.*;

public class VoteServiceTest extends AbstractServiceTest {

    @Autowired
    private VoteService service;

    @Test
    public void testGetAllByUser(){
        List<Vote> list = service.getAllByUser(USER1_ID);
        for(Vote vote : list){
            System.out.println(vote.getRestaurant().getName());
        }
    }

    @Test
    public void testGetAllByDate(){
        List<Vote> list = service.getAllByDate(DATE);
        for(Vote vote : list){
            System.out.println(vote.getRestaurant().getName());
        }
    }

    @Test
    public void testGetLast(){
        service.getLast(USER1_ID);
    }

    @Test
    @Transactional
    public void testUpdate(){
        Vote updated = getUpdated();
        Vote actual = service.update(updated, RESTAURANT_ID+1);
        Assert.assertEquals(updated,actual);
    }

    @Test
    public void testCountVotes(){
        List<RestaurantRatingTo> list = service.countVotes(DATE);
        for(RestaurantRatingTo to : list){
            System.out.println(to.getName() + " : " + to.getRating());
        }
    }

    @Test
    @Transactional
    public void testCreate(){
        Vote created = service.create(USER1_ID, RESTAURANT_ID);
        Vote actual = service.getLast(USER1_ID);
        Assert.assertEquals(created, actual);
    }
}