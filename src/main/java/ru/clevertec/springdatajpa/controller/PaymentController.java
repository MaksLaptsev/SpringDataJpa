package ru.clevertec.springdatajpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.springdatajpa.beans.Initial;
import ru.clevertec.springdatajpa.dto.PaymentResponse;
import ru.clevertec.springdatajpa.model.Payment;
import ru.clevertec.springdatajpa.service.PaymentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;
    private final Initial initial;


    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.findById(id));
    }

    @PostMapping
    public void save(){
        for (Payment payment: initial.getPayments()){
            paymentService.save(payment);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<PaymentResponse>> findAll(){
        return ResponseEntity.ok(paymentService.getAll());
    }
}
