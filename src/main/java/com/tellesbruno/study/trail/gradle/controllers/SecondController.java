package com.tellesbruno.study.trail.gradle.controllers;

import com.tellesbruno.study.trail.gradle.models.People;
import com.tellesbruno.study.trail.gradle.models.PeopleData;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/second")
public class SecondController {
    @GetMapping(path = "/people")
    public People printer(@RequestParam(name = "id", defaultValue = "0") int id){
        PeopleData peopleData = new PeopleData();
        return peopleData.getPeopleList().get(id);
    }

    @GetMapping(path = "/test")
    public List<String> printer2(){
        List<String> test = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            test.add("Valor "+i*2);
        }
        return test;
    }

    @GetMapping(path = "/people/{id}")
    public People printer3(@PathVariable int id){
        PeopleData peopleData = new PeopleData();
        People people = null;
            try {
                people = peopleData.getPeopleList().get(id);
            } catch (IndexOutOfBoundsException e) {
                return peopleData.getPeopleList().get(0);
            }
        return people;
    }
}
