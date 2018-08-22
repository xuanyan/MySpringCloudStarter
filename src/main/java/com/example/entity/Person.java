package com.example.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "agee", nullable = false, length = 4)
    private int age;
}