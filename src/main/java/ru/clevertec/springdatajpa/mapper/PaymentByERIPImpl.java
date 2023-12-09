package ru.clevertec.springdatajpa.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.clevertec.springdatajpa.dto.PaymentRequest;
import ru.clevertec.springdatajpa.dto.PaymentResponse;
import ru.clevertec.springdatajpa.exceptions.InvalidParamsException;
import ru.clevertec.springdatajpa.model.PaymentByERIP;
import java.util.Map;

@Component
public class PaymentByERIPImpl implements PaymentMapper<PaymentByERIP>{
    @Override
    public PaymentResponse toResponse(PaymentByERIP paymentByERIP) {
        Map<String,String> map = Map.of("fieldForInsertion", paymentByERIP.getFieldForInsertion(),"valueForInsertion", paymentByERIP.getValueForInsertion());
        return new PaymentResponse(paymentByERIP.getId(), paymentByERIP.getPaymentFrom(), paymentByERIP.getPaymentTo(),paymentByERIP.getPaymentType(),map);
    }

    @Override
    public PaymentByERIP fromRequest(PaymentRequest request) {
        if (!request.params().isEmpty()){
            return new PaymentByERIP(request.id(),request.paymentFrom(),request.paymentTo(),request.paymentType()
                    ,request.params().get("fieldForInsertion"),request.params().get("valueForInsertion"));
        }else {
            throw new InvalidParamsException("In Payment with type %s , params - must be not null"
                    .formatted(request.paymentType()));
        }

    }

    @Override
    public Class<PaymentByERIP> getClazz() {
        return PaymentByERIP.class;
    }
}
