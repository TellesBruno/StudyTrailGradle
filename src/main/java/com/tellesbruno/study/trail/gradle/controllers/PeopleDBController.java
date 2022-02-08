package com.tellesbruno.study.trail.gradle.controllers;


import com.tellesbruno.study.trail.gradle.models.PeopleDB;
import com.tellesbruno.study.trail.gradle.service.PeopleDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persistence")
    public class PeopleDBController {

    @Autowired
    PeopleDBService peopleDBService;

    @GetMapping("/people-db")
    public List<PeopleDB> getAllPeopleDB(){
        return peopleDBService.getAllPeopleDB();
    }

    @GetMapping("/people-db/{id}")
    public PeopleDB getPeopleDB(@PathVariable(value = "id") int id){
        return peopleDBService.getPeopleDB(id);
    }

    @DeleteMapping("/people-db/{id}")
    public void deletePeopleDB(@PathVariable("id") int id){
        peopleDBService.deletePeopleDB(id);
    }

    @PostMapping("/people-db")
    public void addPeopleDB(@RequestBody PeopleDB peopleDB){
        peopleDBService.addPeopleDB(peopleDB);
    }

}
