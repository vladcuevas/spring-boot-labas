package com.fsdprogram.demo.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.Column;

@Entity
@Table(name = "USERS")
public @Data class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String roles;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Boolean active;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dob;
    private String phoneNumber;
    private String address;
}