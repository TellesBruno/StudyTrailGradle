package com.tellesbruno.study.trail.gradle.repository;

import com.tellesbruno.study.trail.gradle.models.PeopleDB;
import org.springframework.data.repository.CrudRepository;


public interface PeopleDBRepository extends CrudRepository<PeopleDB, Integer> {
}
