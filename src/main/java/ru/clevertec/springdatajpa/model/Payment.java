package ru.clevertec.springdatajpa.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentFrom;
    private String paymentTo;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    public Payment(String paymentTo, String paymentFrom, PaymentType paymentType) {
        this.paymentFrom = paymentFrom;
        this.paymentTo = paymentTo;
        this.paymentType = paymentType;
    }
}
