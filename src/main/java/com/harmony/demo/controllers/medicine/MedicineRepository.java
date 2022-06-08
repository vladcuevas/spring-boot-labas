package com.harmony.demo.controllers.medicine;

import com.harmony.demo.model.Medicine;

import org.springframework.data.jpa.repository.JpaRepository;

interface MedicineRepository extends JpaRepository<Medicine, Long> {

}