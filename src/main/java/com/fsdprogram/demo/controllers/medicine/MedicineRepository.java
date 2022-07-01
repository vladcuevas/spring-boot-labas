package com.fsdprogram.demo.controllers.medicine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fsdprogram.demo.model.Medicine;

@Repository
interface MedicineRepository extends JpaRepository<Medicine, Long> {
    List<Medicine> findByName(String name);
    List<Medicine> findByDiseaseContaining(String disease);
    List<Medicine> findByDisease(String disease);
}