package ru.clevertec.springdatajpa.model;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class PaymentByERIP extends Payment{
    private String fieldForInsertion;
    private String valueForInsertion;

    public PaymentByERIP(String for1, String valueFor1, Payment payment) {
        super(payment.getPaymentTo(),payment.getPaymentFrom(), payment.getPaymentType());
        fieldForInsertion = for1;
        valueForInsertion = valueFor1;
    }

    public PaymentByERIP(Long id, String paymentFrom,String paymentTo,PaymentType paymentType, String for1, String valueFor1) {
        super(id, paymentFrom, paymentTo, paymentType);
        fieldForInsertion = for1;
        valueForInsertion = valueFor1;
    }
}
