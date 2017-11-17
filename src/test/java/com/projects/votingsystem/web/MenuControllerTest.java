package com.projects.votingsystem.web;

import org.junit.Test;
import org.springframework.http.MediaType;

import static com.projects.votingsystem.TestData.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;


public class MenuControllerTest extends AbstractControllerTest {
    public static final String URL = MenuController.URL + "/";


    @Test
    public void getByRestaurant() throws Exception {
        mockMvc.perform(get(URL + RESTAURANT_ID)
                .with(httpBasic(ADMIN.getEmail(), ADMIN.getPassword())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void createWithLocation() throws Exception {
        mockMvc.perform(post(URL)
                .with(csrf().asHeader())
                .with(httpBasic(ADMIN.getEmail(), ADMIN.getPassword()))
                .param("restaurantId", String.valueOf(RESTAURANT_ID)))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}