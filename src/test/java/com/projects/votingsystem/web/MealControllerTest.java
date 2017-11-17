package com.projects.votingsystem.web;

import com.projects.votingsystem.model.Meal;
import org.junit.Test;
import org.springframework.http.MediaType;

import static com.projects.votingsystem.TestData.*;
import static com.projects.votingsystem.web.json.JacksonObjectMapper.getMapper;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

public class MealControllerTest extends AbstractControllerTest {
    public static final String URL = MealController.URL + "/";


    @Test
    public void testCreate() throws Exception {
        mockMvc.perform(post(URL)
                .with(csrf().asHeader())
                .with(httpBasic(ADMIN.getEmail(), ADMIN.getPassword()))
                .param("menuId", String.valueOf(MENU_ID))
                .contentType(MediaType.APPLICATION_JSON)
                .content(getMapper().writeValueAsString(CREATED_MEAL)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void testUpdate() throws Exception {
        mockMvc.perform(put(URL + MEAL_ID)
                .with(csrf().asHeader())
                .with(httpBasic(ADMIN.getEmail(), ADMIN.getPassword()))
                .contentType(MediaType.APPLICATION_JSON)
                .content(getMapper().writeValueAsString(UPDATED_MEAL)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(URL + MEAL_ID)
                .with(csrf().asHeader())
                .with(httpBasic(ADMIN.getEmail(), ADMIN.getPassword())))
                .andExpect(status().isOk());
    }

    @Test
    public void TestGet() throws Exception {
        mockMvc.perform(get(URL + MEAL_ID)
                .with(httpBasic(ADMIN.getEmail(), ADMIN.getPassword())))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void testCreateError() throws Exception {
        Meal FAILED_MEAL = new Meal(null, "N", -5);

        mockMvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(getMapper().writeValueAsString(FAILED_MEAL))
                .with(httpBasic(ADMIN.getEmail(), ADMIN.getPassword()))
                .param("menuId", String.valueOf(MENU_ID)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

}