package com.fsdprogram.demo.controllers.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsdprogram.demo.model.Orders;

interface OrderRepository extends JpaRepository<Orders, Long> {

}