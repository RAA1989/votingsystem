package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Restaurant;
import com.projects.votingsystem.model.Vote;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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
    public void testSave(){
        Vote updated = getUpdated();
        service.save(updated, USER1_ID, RESTAURANT_ID);
        Vote actual = service.getLast(USER1_ID);
        Assert.assertEquals(updated, actual);
    }

    @Test
    public void testCountVotes(){
        Map<Restaurant, List<Vote>> map = service.countVotes(DATE);
        for(Map.Entry<Restaurant, List<Vote>> set : map.entrySet()){
            System.out.println(set.getKey().getName() + " : " + set.getValue().get(2).getRestaurant().getName());
        }
    }
}
