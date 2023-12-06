package ru.clevertec.springdatajpa.mapper;

import ru.clevertec.springdatajpa.dto.PaymentResponse;

public interface PaymentMapper<T> {
    PaymentResponse toResponse(T t);
    T fromRequest();
    Class<T> getClazz();

}
