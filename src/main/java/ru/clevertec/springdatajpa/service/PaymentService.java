package ru.clevertec.springdatajpa.service;

import ru.clevertec.springdatajpa.dto.PaymentResponse;
import ru.clevertec.springdatajpa.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    PaymentResponse findById(Long id);
    PaymentResponse save(Payment payment);

    List<PaymentResponse> getAll();
}
