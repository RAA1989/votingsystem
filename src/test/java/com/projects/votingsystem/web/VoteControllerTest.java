package com.projects.votingsystem.web;

import org.junit.Test;

import org.springframework.http.MediaType;


import static com.projects.votingsystem.TestData.*;
import static com.projects.votingsystem.TestData.ADMIN;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class VoteControllerTest extends AbstractControllerTest {
    public static final String URL = VoteController.URL + "/";

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
                .with(csrf().asHeader())
                .with(httpBasic(USER.getEmail(), USER.getPassword()))
                .param("restaurantId", String.valueOf(RESTAURANT_ID + 1)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

//  For successful fulfilment must be launched after 11:00
    @Test
    public void testUpdateAfterDeadline() throws Exception {
        mockMvc.perform(post(URL)
                .with(csrf().asHeader())
                .with(httpBasic(USER.getEmail(), USER.getPassword()))
                .param("restaurantId", String.valueOf(RESTAURANT_ID)));

        mockMvc.perform(post(URL)
                .with(csrf().asHeader())
                .with(httpBasic(USER.getEmail(), USER.getPassword()))
                .param("restaurantId", String.valueOf(RESTAURANT_ID + 1)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetAllByUser() throws Exception {
        mockMvc.perform(get(URL + USER1_ID)
                .with(httpBasic(ADMIN.getEmail(), ADMIN.getPassword())))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
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