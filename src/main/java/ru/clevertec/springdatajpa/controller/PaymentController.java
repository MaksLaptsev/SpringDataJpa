package ru.clevertec.springdatajpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.springdatajpa.dto.PaymentRequest;
import ru.clevertec.springdatajpa.dto.PaymentResponse;
import ru.clevertec.springdatajpa.service.PaymentService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PaymentResponse> save(@RequestBody PaymentRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.save(request));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PaymentResponse>> findAll(){
        return ResponseEntity.ok(paymentService.getAll());
    }

}
