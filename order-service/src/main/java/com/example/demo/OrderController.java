package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final List<Map<String, Object>> orders = new ArrayList<>();
    private int idCounter = 1;

    @GetMapping
    public List<Map<String, Object>> getOrders() {
        return orders;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> placeOrder(@RequestBody Map<String, Object> order) {
        // Sample: {"item":"Laptop","quantity":2,"customerId":"C001"}
        order.put("id", idCounter++);
        order.put("status", "PENDING");
        orders.add(order);
        return ResponseEntity.status(201).body(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrder(@PathVariable int id) {
        return orders.stream()
                .filter(o -> Objects.equals(o.get("id"), id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}