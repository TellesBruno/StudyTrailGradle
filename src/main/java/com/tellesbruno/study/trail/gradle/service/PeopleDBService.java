package com.tellesbruno.study.trail.gradle.service;

import com.tellesbruno.study.trail.gradle.errors.HttpRequestExeption;
import com.tellesbruno.study.trail.gradle.models.PeopleDB;
import com.tellesbruno.study.trail.gradle.repository.PeopleDBRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class PeopleDBService {

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
            throw new HttpRequestExeption(
                    "Not Found",
                    "PeopleDB " + id +" not found",
                    HttpStatus.NOT_FOUND.value());
        }
    }

    public ResponseEntity<?> addPeopleDB(PeopleDB peopleDB) {
        if (peopleDBRepository.findById(peopleDB.getId()).isEmpty()) {
            try {
                peopleDBRepository.save(peopleDB);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(peopleDB.getId())
                    .toUri();
            return ResponseEntity.created(location).body(peopleDB);
        } else {
            throw new HttpRequestExeption(
                    "Bad Request",
                    "PeopleDB " + peopleDB.getId() +" already exist",
                    HttpStatus.BAD_REQUEST.value());
        }
    }

    public ResponseEntity<?> updatePeopleDB(int id, PeopleDB peopleDB) {
        if (peopleDB.getId() == id) {
            if (peopleDBRepository.findById(id).isPresent()) {
                try {
                    peopleDBRepository.save(peopleDB);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                throw new HttpRequestExeption(
                    "Not Found",
                    "PeopleDB " + id +" not found",
                    HttpStatus.NOT_FOUND.value());
        }} else {
            throw new HttpRequestExeption(
                    "Bad Request",
                    "PeopleDB ID" + peopleDB.getId() +" not match with ID" + id,
                    HttpStatus.BAD_REQUEST.value());
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<?> deletePeopleDB(int id) {
        PeopleDB deletedPeopleDB;
        try {
            deletedPeopleDB = peopleDBRepository.findById(id).get();
            peopleDBRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new HttpRequestExeption(
                    "Not Found",
                    "PeopleDB " + id +" not found",
                    HttpStatus.NOT_FOUND.value());
        }
        return ResponseEntity.ok().body(deletedPeopleDB);
    }
}
