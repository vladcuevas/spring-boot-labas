package com.fsdprogram.demo.model;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String name;
    @Column(nullable = false)
    private String companyName;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Integer uses;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer discount;   
    @Column(nullable = false)
    private Short rating;    
    @Column(name = "disease",nullable = false)
    private String disease;
    @Column(nullable = false)
    private String image;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date expirationDate;
}