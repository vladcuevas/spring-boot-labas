package com.harmony.demo.controllers.medicine;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.harmony.demo.model.Medicine;

@RestController
public class MedicineController {
    private final MedicineRepository repository;

    MedicineController(MedicineRepository repository) {
        this.repository = repository;
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/api/admin/medicines")
    List<Medicine> all() {
        return repository.findAll();
    }

    @PostMapping("/api/admin/medicines")
    public ResponseEntity<Object> createMedicine(@RequestBody Medicine newMedicine) {
        Medicine savedMedicine = repository.save(newMedicine);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedMedicine.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    // Single item

    @GetMapping("/api/admin/medicines/{id}")
    Medicine one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new MedicineNotFoundException(id));
    }

    @PutMapping("/api/admin/medicines/{id}")
    Medicine replaceMedicine(@RequestBody Medicine newMedicine, @PathVariable Long id) {

        return repository.findById(id)
                .map(medicine -> {
                    medicine.setName(newMedicine.getName());
                    medicine.setCompanyName(newMedicine.getCompanyName());
                    medicine.setPrice(newMedicine.getPrice());
                    medicine.setUses(newMedicine.getUses());
                    medicine.setExpirationDate(newMedicine.getExpirationDate());
                    return repository.save(medicine);
                })
                .orElseGet(() -> {
                    newMedicine.setId(id);
                    return repository.save(newMedicine);
                });
    }

    @DeleteMapping("/api/admin/medicines/{id}")
    void deleteMedicine(@PathVariable Long id) {
        repository.deleteById(id);
    }
}