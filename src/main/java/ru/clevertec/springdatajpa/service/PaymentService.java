package ru.clevertec.springdatajpa.service;

import ru.clevertec.springdatajpa.dto.PaymentRequest;
import ru.clevertec.springdatajpa.dto.PaymentResponse;
import java.util.List;

public interface PaymentService {

    PaymentResponse findById(Long id);
    PaymentResponse save(PaymentRequest request);
    List<PaymentResponse> getAll();
}
