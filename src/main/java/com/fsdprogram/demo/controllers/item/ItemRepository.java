package com.fsdprogram.demo.controllers.item;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsdprogram.demo.model.Item;

interface ItemRepository extends JpaRepository<Item, Long> {

}