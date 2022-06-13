package com.tellesbruno.study.trail.gradle.controllers;

import com.tellesbruno.study.trail.gradle.models.PeopleDB;
import com.tellesbruno.study.trail.gradle.service.PeopleDBService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

//@RunWith(MockitoExtension.class)
//@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(PeopleDBController.class)
class PeopleDBControllerTest {

    @InjectMocks
    private PeopleDBController peopleDBController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PeopleDBService peopleDBService;

    @Test
    void shouldGetAllPeople() throws Exception {
        PeopleDB people1 = new PeopleDB(1,"Joao", "12345678900", "password");
        PeopleDB people2 = new PeopleDB(2,"Jose", "11122233300", "password");
        PeopleDB people3 = new PeopleDB(3,"Maria", "44455566600", "password");

    }

//    @Test
//    void shouldGetPeopleByID(){
//
//    }
//
//    @Test
//    void shouldPostNewPeople(){
//
//    }
//
//    @Test
//    void shouldUpdatePeople(){
//
//    }
//
//    @Test
//    void shouldDeletePeopleByID(){
//
//    }
}
