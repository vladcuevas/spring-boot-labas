package com.fsdprogram.demo.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public @Data class Medicine {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String companyName;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private String disease;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    Date expirationDate;
}