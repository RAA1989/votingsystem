package com.projects.votingsystem.web;

import com.projects.votingsystem.model.Vote;
import com.projects.votingsystem.service.VoteService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;


import static com.projects.votingsystem.TestData.RESTAURANT_ID;
import static com.projects.votingsystem.TestData.VOTE1_ID;
import static com.projects.votingsystem.TestData.getUpdated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.projects.votingsystem.web.json.JacksonObjectMapper.getMapper;


public class VoteControllerTest extends AbstractControllerTest {
    public static final String URL = VoteController.URL + "/";

    @Autowired
    private VoteService voteService;

    @Test
    public void testShowVotes() throws Exception {
        mockMvc.perform(get(URL + "result"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreate() throws Exception {
        mockMvc.perform(post(URL)
                .param("restaurantId", String.valueOf(RESTAURANT_ID + 1))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdate() throws Exception {
        Vote updated = getUpdated();

        mockMvc.perform(put(URL + VOTE1_ID)
                .param("restaurantId", String.valueOf(RESTAURANT_ID + 1))
        .contentType(MediaType.APPLICATION_JSON)
        .content(getMapper().writeValueAsString(updated)))
        .andDo(print())
        .andExpect(status().isOk());
    }

    @Test
    public void testGetAllByUser() throws Exception {
        mockMvc.perform(get(URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetLast() throws Exception {
        mockMvc.perform(get(URL + "/last"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}