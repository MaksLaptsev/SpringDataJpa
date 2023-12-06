package ru.clevertec.springdatajpa.model;

import jakarta.persistence.Entity;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class PaymentByRequisite extends Payment{
    private String unp;
    private String receiver;
    private String destination;

    public PaymentByRequisite(String desc1, String reciver1, String unp1, Payment payment) {
        super(payment.getPaymentTo(),payment.getPaymentFrom(), payment.getPaymentType());
        unp = unp1;
        receiver = reciver1;
        destination = desc1;
    }

    public PaymentByRequisite(Long id, String paymentFrom,String paymentTo,PaymentType paymentType,String desc1, String reciver1, String unp1) {
        super(id, paymentFrom, paymentTo, paymentType);
        unp = unp1;
        receiver = reciver1;
        destination = desc1;
    }
}
