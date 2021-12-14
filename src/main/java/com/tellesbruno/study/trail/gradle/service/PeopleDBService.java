package com.tellesbruno.study.trail.gradle.service;

import com.tellesbruno.study.trail.gradle.models.PeopleDB;
import com.tellesbruno.study.trail.gradle.repository.PeopleDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PeopleDBService {
    @Autowired
    PeopleDBRepository peopleDBRepository;

    public List<PeopleDB> getAllPeopleDB() {
        List<PeopleDB> peopleDBs = new ArrayList<>();
        peopleDBRepository.findAll().forEach(peopleDBs::add);
        return peopleDBs;
    }

    public PeopleDB getPeopleDB(int id) {
        try {
            return peopleDBRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            return new PeopleDB();
        }
    }

    public void addPeopleDB(PeopleDB peopleDB) {
        peopleDBRepository.save(peopleDB);
    }

    public void updatePeopleDB(PeopleDB peopleDB) {
        peopleDBRepository.save(peopleDB);
    }

    public void deletePeopleDB(int id) {
        peopleDBRepository.deleteById(id);
    }
}
