package com.fsdprogram.demo.controllers.medicine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsdprogram.demo.model.Medicine;

interface MedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findByName(String name);
    List<Medicine> findByUsesContaining(String uses);
    List<Medicine> findByUses(String uses);
}