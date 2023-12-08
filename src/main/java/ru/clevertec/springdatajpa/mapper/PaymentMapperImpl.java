package ru.clevertec.springdatajpa.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.clevertec.springdatajpa.dto.PaymentRequest;
import ru.clevertec.springdatajpa.dto.PaymentResponse;
import ru.clevertec.springdatajpa.model.Payment;

@Component
public class PaymentMapperImpl implements PaymentMapper<Payment>{
    @Override
    public PaymentResponse toResponse(Payment payment) {
        return new PaymentResponse(payment.getId(),payment.getPaymentFrom(), payment.getPaymentTo(),payment.getPaymentType(),null);
    }

    @Override
    public Payment fromRequest(PaymentRequest request) {
        return new Payment(request.id(), request.paymentFrom(), request.paymentTo(), request.paymentType());
    }

    @Override
    public Class<Payment> getClazz() {
        return Payment.class;
    }
}
