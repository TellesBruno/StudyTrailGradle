package com.tellesbruno.study.trail.gradle.service;

import com.tellesbruno.study.trail.gradle.errors.HttpRequestExeption;
import com.tellesbruno.study.trail.gradle.models.PeopleDB;
import com.tellesbruno.study.trail.gradle.models.PeopleDBModel;
import com.tellesbruno.study.trail.gradle.repository.PeopleDBRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class PeopleDBService {

    private static final String N_FOUND = "Not Found";
    private static final String B_REQUEST = "Bad Request";

    private static final Logger LOG = Logger.getLogger(PeopleDBService.class.getName());

    PeopleDBRepository peopleDBRepository;

    public List<PeopleDB> getAllPeopleDB() {
        List<PeopleDB> peopleDBs = new ArrayList<>();
        peopleDBRepository.findAll().forEach(peopleDBs::add);
        return peopleDBs;
    }

    public PeopleDB getPeopleDB(int id) {
        Optional<PeopleDB> optionalPeopleDB = peopleDBRepository.findById(id);
        try {
            if (optionalPeopleDB.isPresent()){
                return optionalPeopleDB.get();
            } else {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            throw new HttpRequestExeption(
                    N_FOUND,
                    idMessageGenerator(id),
                    HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<PeopleDB> addPeopleDB(PeopleDBModel people) {
        var peopleDB = new PeopleDB(people.getId(), people.getName(), people.getCpf(), people.getPassword());
        if (peopleDBRepository.findById(people.getId()).isEmpty()) {
            try {
                peopleDBRepository.save(peopleDB);
            } catch (Exception e) {
                LOG.info(e.getMessage());
            }
            var location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(people.getId())
                    .toUri();
            return ResponseEntity.created(location).body(peopleDB);
        } else {
            throw new HttpRequestExeption(
                    B_REQUEST,
                    "PeopleDB " + peopleDB.getId() +" already exist",
                    HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<PeopleDB> updatePeopleDB(int id, PeopleDBModel people) {
        var peopleDB = new PeopleDB(people.getId(), people.getName(), people.getCpf(), people.getPassword());
        if (peopleDB.getId() == id) {
            if (peopleDBRepository.findById(id).isPresent()) {
                try {
                    peopleDBRepository.save(peopleDB);
                } catch (Exception e) {
                    LOG.info(e.getMessage());
                }
            } else {
                throw new HttpRequestExeption(
                        N_FOUND,
                    idMessageGenerator(id),
                    HttpStatus.NOT_FOUND);
        }} else {
            throw new HttpRequestExeption(
                    B_REQUEST,
                    "PeopleDB ID" + peopleDB.getId() +" not match with ID" + id,
                    HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<PeopleDB> deletePeopleDB(int id) {
        Optional<PeopleDB> optionalPeopleDB = peopleDBRepository.findById(id);
        PeopleDB deletedPeopleDB;
        try {
            if (optionalPeopleDB.isPresent()){
                deletedPeopleDB = optionalPeopleDB.get();
                peopleDBRepository.deleteById(id);
            } else {
                throw new NoSuchElementException();
            }
        } catch (NoSuchElementException e) {
            throw new HttpRequestExeption(
                    N_FOUND,
                    idMessageGenerator(id),
                    HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(deletedPeopleDB);
    }

    private String idMessageGenerator(int id) {
        return "PeopleDB ID " + id + " not found";
    }
}
