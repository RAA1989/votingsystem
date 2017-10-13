package com.projects.votingsystem.service;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static com.projects.votingsystem.VoteTestData.VOTE1;
import static com.projects.votingsystem.VoteTestData.VOTE1_ID;

public class VoteServiceTest extends AbstractServiceTest {

    @Autowired
    private VoteService service;

    @Test
    @Transactional
    public void testGetAllByUser(){
        System.out.println(service.getAllByUser(VOTE1_ID));;
    }

}
