package com.fsdprogram.demo.controllers.medicine;

public class MedicineNotFoundException extends RuntimeException{
    MedicineNotFoundException(Long id) {
        super("Could not find medicine " + id);
      }
}
