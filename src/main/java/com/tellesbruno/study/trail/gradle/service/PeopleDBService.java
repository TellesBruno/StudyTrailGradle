package com.tellesbruno.study.trail.gradle.service;

import com.tellesbruno.study.trail.gradle.errors.BadRequestExeption;
import com.tellesbruno.study.trail.gradle.errors.NotFoundExeption;
import com.tellesbruno.study.trail.gradle.models.PeopleDB;
import com.tellesbruno.study.trail.gradle.repository.PeopleDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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
            throw new NotFoundExeption("PeopleDB " + id +" not found");
        } catch (Exception e) {
            throw new BadRequestExeption("Bad Request");
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
