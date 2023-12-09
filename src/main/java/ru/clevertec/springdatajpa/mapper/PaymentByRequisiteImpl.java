package ru.clevertec.springdatajpa.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.clevertec.springdatajpa.dto.PaymentRequest;
import ru.clevertec.springdatajpa.dto.PaymentResponse;
import ru.clevertec.springdatajpa.exceptions.InvalidParamsException;
import ru.clevertec.springdatajpa.model.PaymentByRequisite;
import java.util.Map;

@Component
public class PaymentByRequisiteImpl implements PaymentMapper<PaymentByRequisite>{
    @Override
    public PaymentResponse toResponse(PaymentByRequisite paymentByRequisite) {
        Map<String,String> map = Map.of("unp", paymentByRequisite.getUnp(),"receiver",
                paymentByRequisite.getReceiver(),"destination", paymentByRequisite.getDestination());

        return new PaymentResponse(paymentByRequisite.getId(), paymentByRequisite.getPaymentFrom(),
                paymentByRequisite.getPaymentTo(), paymentByRequisite.getPaymentType(),map);
    }

    @Override
    public PaymentByRequisite fromRequest(PaymentRequest request) {
        if (!request.params().isEmpty()){
            return new PaymentByRequisite(request.id(), request.paymentFrom(), request.paymentTo(), request.paymentType(),
                    request.params().get("unp"),request.params().get("receiver"),request.params().get("destination"));
        }else {
            throw new InvalidParamsException("In Payment with type %s , params - must be not null"
                    .formatted(request.paymentType()));
        }

    }

    @Override
    public Class<PaymentByRequisite> getClazz() {
        return PaymentByRequisite.class;
    }
}
