package com.tellesbruno.study.trail.gradle.models;

import java.util.List;

public class PeopleData {
    List<People> peopleList = List.of(
            new People("Null", "Null"),
            new People("Ana", "123"),
            new People("Bruno", "456"),
            new People("Carlos", "789"));

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }
}
