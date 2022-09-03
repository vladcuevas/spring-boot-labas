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

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;

@Entity
@Table(name = "USERS")
public @Data class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private Boolean active;    
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dob;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String roles;
}