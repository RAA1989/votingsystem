package com.projects.votingsystem.web;

import com.projects.votingsystem.model.Vote;
import com.projects.votingsystem.service.VoteService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;


import static com.projects.votingsystem.TestData.*;
import static com.projects.votingsystem.TestData.ADMIN;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
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
        mockMvc.perform(get(URL + "result")
                .with(httpBasic(USER.getEmail(), USER.getPassword())))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreate() throws Exception {
        mockMvc.perform(post(URL)
                .with(httpBasic(USER.getEmail(), USER.getPassword()))
                .param("restaurantId", String.valueOf(RESTAURANT_ID + 1))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

//    @Test
//    public void testUpdate() throws Exception {
//        Vote updated = getUpdated();
//
//        mockMvc.perform(put(URL + VOTE1_ID)
//                .param("restaurantId", String.valueOf(RESTAURANT_ID + 1))
//        .contentType(MediaType.APPLICATION_JSON)
//        .content(getMapper().writeValueAsString(updated)))
//        .andDo(print())
//        .andExpect(status().isOk());
//    }

    @Test
    public void testGetAllByUser() throws Exception {
        mockMvc.perform(get("/votes")
                .with(httpBasic(ADMIN.getEmail(), ADMIN.getPassword())))
                .andExpect(status().isOk())
                .andDo(print());
                //.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetLast() throws Exception {
        mockMvc.perform(get(URL + "last")
                .with(httpBasic(USER.getEmail(), USER.getPassword())))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}