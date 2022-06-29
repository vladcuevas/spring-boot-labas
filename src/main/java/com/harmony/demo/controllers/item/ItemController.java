package com.harmony.demo.controllers.item;

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

import com.harmony.demo.model.Item;

@RestController
public class ItemController {
    private final ItemRepository repository;

    ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/item")
    List<Item> all() {
        return repository.findAll();
    }

    @PostMapping("/item")
    public ResponseEntity<Object> createItem(@RequestBody Item newItem) {
        Item savedItem = repository.save(newItem);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedItem.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    // Single item

    @GetMapping("/item/{id}")
    Item one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @PutMapping("/item/{id}")
    Item replaceItem(@RequestBody Item newItem, @PathVariable Long id) {

        return repository.findById(id)
                .map(item -> {
                    item.setQuantity(newItem.getQuantity());
                    return repository.save(item);
                })
                .orElseGet(() -> {
                    newItem.setId(id);
                    return repository.save(newItem);
                });
    }

    @DeleteMapping("/item/{id}")
    void deleteItem(@PathVariable Long id) {
        repository.deleteById(id);
    }
}