package com.fsdprogram.demo.controllers.medicine;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsdprogram.demo.model.Medicine;

interface MedicineRepository extends JpaRepository<Medicine, Long> {

}