package com.harmony.demo.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public @Data class Employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private int id;
    private String name;
    private String lastName;
    private int badgeNumber;
}