package com.tellesbruno.study.trail.gradle.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter @Setter @NoArgsConstructor
public class PeopleDB {

    @Id
    @Column
    private int id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 11, nullable = false)
    private String cpf;
}
