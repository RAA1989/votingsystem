package com.projects.votingsystem.web;

import com.projects.votingsystem.model.Restaurant;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.net.URI;

import static com.projects.votingsystem.web.json.JacksonObjectMapper.getMapper;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


import static org.junit.Assert.*;


public class RestaurantControllerTest extends AbstractControllerTest {
    public static final String URL = RestaurantController.URL + "/";


    @Test
    public void testGetAllEnabledWithMenu() throws Exception {
        mockMvc.perform(get(URL))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreate() throws Exception {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("New Restaurant");

        mockMvc.perform(post(URL)
        .contentType(MediaType.APPLICATION_JSON)
        .content(getMapper().writeValueAsString(restaurant)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(URL + "all"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

}