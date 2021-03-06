package com.projects.votingsystem.web;

import com.projects.votingsystem.model.Restaurant;
import org.junit.Test;
import org.springframework.http.MediaType;


import static com.projects.votingsystem.TestData.ADMIN;
import static com.projects.votingsystem.web.json.JacksonObjectMapper.getMapper;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


public class RestaurantControllerTest extends AbstractControllerTest {
    public static final String URL = RestaurantController.URL + "/";


    @Test
    public void testGetAllWithLastMenu() throws Exception {
        mockMvc.perform(get(URL)
                .with(httpBasic(ADMIN.getEmail(), ADMIN.getPassword())))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreate() throws Exception {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("New Restaurant");

        mockMvc.perform(post(URL)
                .with(csrf().asHeader())
                .with(httpBasic(ADMIN.getEmail(), ADMIN.getPassword()))
                .contentType(MediaType.APPLICATION_JSON)
                .content(getMapper().writeValueAsString(restaurant)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreateInvalid() throws Exception {
        Restaurant restaurant = new Restaurant();
        restaurant.setName("R");

        mockMvc.perform(post(URL)
                .with(csrf().asHeader())
                .with(httpBasic(ADMIN.getEmail(), ADMIN.getPassword()))
                .contentType(MediaType.APPLICATION_JSON)
                .content(getMapper().writeValueAsString(restaurant)))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(URL + "all")
                .with(httpBasic(ADMIN.getEmail(), ADMIN.getPassword())))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testGetUnauth() throws Exception {
        mockMvc.perform(get(URL + "all"))
                .andExpect(status().isUnauthorized());
    }

}