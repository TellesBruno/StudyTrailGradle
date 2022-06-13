package com.tellesbruno.study.trail.gradle.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tellesbruno.study.trail.gradle.service.PeopleDBService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PeopleDBService.class)
public class PeopleDBServiceTest {

    @MockBean
    private PeopleDBService peopleDBService;

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetAllPeople() throws Exception {

    }
}
