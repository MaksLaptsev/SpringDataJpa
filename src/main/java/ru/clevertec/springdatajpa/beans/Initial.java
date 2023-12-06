package ru.clevertec.springdatajpa.beans;

import org.springframework.stereotype.Component;
import ru.clevertec.springdatajpa.model.Payment;
import ru.clevertec.springdatajpa.model.PaymentByERIP;
import ru.clevertec.springdatajpa.model.PaymentByRequisite;
import ru.clevertec.springdatajpa.model.PaymentType;

import java.util.List;

@Component
public class Initial {
    private List<Payment> payments;

    public Initial() {
        Payment p = new Payment(1L,"from1","to1", PaymentType.CARD);
        Payment p1 = new Payment(2L,"from2","to2", PaymentType.ACCOUNT);
        Payment p2 = new Payment(3L,"from3","to3", PaymentType.PHONE);
        PaymentByERIP erip = new PaymentByERIP(4L,"from3","from3",PaymentType.ERIP,
                "fieldForInsertion1","valueForInsertion2");
        PaymentByRequisite requisite = new PaymentByRequisite(4L,"from3","from3",PaymentType.REQUISITE,
                "unp1","receiver1","destination1");
        this.payments = List.of(p,p1,p2,erip,requisite);
    }

    public List<Payment> getPayments() {
        return payments;
    }
}
