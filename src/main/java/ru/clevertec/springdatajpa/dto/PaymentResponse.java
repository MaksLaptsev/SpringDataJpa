package ru.clevertec.springdatajpa.dto;

import ru.clevertec.springdatajpa.model.PaymentType;

import java.util.Map;

public record PaymentResponse(Long id,
                              String paymentFrom,
                              String paymentTo,
                              PaymentType paymentType,
                              Map<String, String> params) {
}
