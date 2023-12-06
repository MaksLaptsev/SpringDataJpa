package ru.clevertec.springdatajpa.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.clevertec.springdatajpa.dto.PaymentResponse;
import ru.clevertec.springdatajpa.mapper.PaymentMapper;
import ru.clevertec.springdatajpa.model.Payment;
import ru.clevertec.springdatajpa.model.PaymentByERIP;
import ru.clevertec.springdatajpa.model.PaymentByRequisite;
import ru.clevertec.springdatajpa.repository.PaymentRepository;
import ru.clevertec.springdatajpa.service.PaymentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final List<PaymentMapper> paymentMappers;
    private Map<Class,PaymentMapper> mapperMap = new HashMap<>();

    @PostConstruct
    private void init(){
        for (PaymentMapper mapper:paymentMappers){
            mapperMap.put(mapper.getClazz(),mapper);
        }
    }

    @Override
    public PaymentResponse findById(Long id) {
        return paymentRepository.findById(id)
                .map(this::getResponse)
                .orElseThrow();
    }

    @Override
    public PaymentResponse save(Payment payment) {
        return Optional.of(paymentRepository.saveAndFlush(payment))
                .map(this::getResponse)
                .orElseThrow();
    }

    @Override
    public List<PaymentResponse> getAll() {
        return paymentRepository.findAll().stream()
                .map(this::getResponse)
                .collect(Collectors.toList());
    }

    private PaymentResponse getResponse(Payment p){
        switch (p.getPaymentType()){
            case ERIP -> {
                return mapperMap.get(PaymentByERIP.class).toResponse(p);
            }
            case REQUISITE -> {
                return mapperMap.get(PaymentByRequisite.class).toResponse(p);
            }
            default -> {
                return mapperMap.get(Payment.class).toResponse(p);
            }
        }
    }
}
