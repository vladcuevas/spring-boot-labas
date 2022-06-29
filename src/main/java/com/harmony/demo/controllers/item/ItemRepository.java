package com.harmony.demo.controllers.item;

import com.harmony.demo.model.Item;

import org.springframework.data.jpa.repository.JpaRepository;

interface ItemRepository extends JpaRepository<Item, Long> {

}