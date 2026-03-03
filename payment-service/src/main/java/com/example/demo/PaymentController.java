package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final List<Map<String, Object>> payments = new ArrayList<>();
    private int idCounter = 1;

    @GetMapping
    public List<Map<String, Object>> getPayments() {
        return payments;
    }

    @PostMapping("/process")
    public ResponseEntity<Map<String, Object>> processPayment(@RequestBody Map<String, Object> payment) {
        // Sample: {"orderId":1,"amount":1299.99,"method":"CARD"}
        payment.put("id", idCounter++);
        payment.put("status", "SUCCESS");
        payments.add(payment);
        return ResponseEntity.status(201).body(payment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPayment(@PathVariable int id) {
        return payments.stream()
                .filter(p -> Objects.equals(p.get("id"), id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}