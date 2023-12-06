package ru.clevertec.springdatajpa.mapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.clevertec.springdatajpa.dto.PaymentResponse;
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
    public PaymentByERIP fromRequest() {
        return null;
    }

    @Override
    public Class<PaymentByERIP> getClazz() {
        return PaymentByERIP.class;
    }
}
