package com.tellesbruno.study.trail.gradle.controllers;


import com.tellesbruno.study.trail.gradle.models.LoginToken;
import com.tellesbruno.study.trail.gradle.models.PeopleDB;
import com.tellesbruno.study.trail.gradle.service.AuthService;
import com.tellesbruno.study.trail.gradle.service.PeopleDBService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/persistence")
    public class PeopleDBController {

    PeopleDBService peopleDBService;
    AuthService authService;

    @GetMapping("/people-db")
    public List<PeopleDB> getAllPeopleDB(){
        return peopleDBService.getAllPeopleDB();
    }

    @GetMapping("/people-db/{id}")
    public PeopleDB getPeopleDB(@PathVariable(value = "id") int id){
        return peopleDBService.getPeopleDB(id);
    }

    @DeleteMapping("/people-db/{id}")
    public ResponseEntity<?> deletePeopleDB(@PathVariable("id") int id){
        return peopleDBService.deletePeopleDB(id);
    }

    @PostMapping("/people-db")
    public ResponseEntity<?> addPeopleDB(@RequestBody PeopleDB peopleDB){
        return peopleDBService.addPeopleDB(peopleDB);
    }

    @PutMapping("/people-db/{id}")
    public ResponseEntity<?> updatePeopleDB(@PathVariable("id") int id, @RequestBody PeopleDB peopleDB){
        return peopleDBService.updatePeopleDB(id, peopleDB);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody LoginToken loginToken){
        return authService.login(loginToken);
    }
}
