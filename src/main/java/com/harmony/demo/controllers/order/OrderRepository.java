package com.harmony.demo.controllers.order;

import com.harmony.demo.model.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

interface OrderRepository extends JpaRepository<Orders, Long> {

}