package com.tellesbruno.study.trail.gradle.models;

public class PeopleDBModel {
    private int id;
    private String name;
    private String cpf;
    private String password;

    public PeopleDBModel(){}

    public PeopleDBModel(int id, String name, String cpf, String password) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.password = password;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword(){ return password; }

    public void setPassword(String password){ this.password = password; }

}
