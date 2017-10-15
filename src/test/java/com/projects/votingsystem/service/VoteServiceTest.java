package com.projects.votingsystem.service;


import com.projects.votingsystem.model.Vote;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.projects.votingsystem.VoteTestData.*;

public class VoteServiceTest extends AbstractServiceTest {

    @Autowired
    private VoteService service;

    @Test
    public void testGetAllByUser(){
        service.getAllByUser(USER1_ID);
    }

    @Test
    public void testGetAllByDate(){
        service.getAllByDate(DATE);
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
}
