package com.fsdprogram.demo.controllers.order;

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

import com.fsdprogram.demo.model.Orders;

@RestController
public class OrderController {
    private final OrderRepository repository;

    OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/admin/order")
    List<Orders> all() {
        return repository.findAll();
    }

    @PostMapping("/order")
    public ResponseEntity<Object> createOrder(@RequestBody Orders newOrder) {
        Orders savedOrder = repository.save(newOrder);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedOrder.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    // Single item

    @GetMapping("/order/{id}")
    Orders one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    @PutMapping("/order/{id}")
    Orders replaceOrder(@RequestBody Orders newOrder, @PathVariable Long id) {

        return repository.findById(id)
                .map(order -> {
                    order.setOrderDate(newOrder.getOrderDate());
                    order.setOrderNum(newOrder.getOrderNum());
                    order.setAmount(newOrder.getAmount());
                    order.setCustomerName(newOrder.getCustomerName());
                    order.setCustomerAddress(newOrder.getCustomerAddress());
                    order.setCustomerEmail(newOrder.getCustomerEmail());
                    order.setCustomerPhone(newOrder.getCustomerPhone());
                    return repository.save(order);
                })
                .orElseGet(() -> {
                    newOrder.setId(id);
                    return repository.save(newOrder);
                });
    }

    @DeleteMapping("/order/{id}")
    void deleteOrder(@PathVariable Long id) {
        repository.deleteById(id);
    }
}