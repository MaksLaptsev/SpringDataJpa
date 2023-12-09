package ru.clevertec.springdatajpa.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.clevertec.springdatajpa.exceptions.InvalidParamsException;
import ru.clevertec.springdatajpa.exceptions.PaymentNotFoundException;
import ru.clevertec.springdatajpa.exceptions.PaymentSaveException;
import ru.clevertec.springdatajpa.exceptions.dto.ExceptionResponse;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<?> handlPaymentNotFoundException(PaymentNotFoundException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionResponse(exception.getMessage()));
    }

    @ExceptionHandler(PaymentSaveException.class)
    public ResponseEntity<?> handlPaymentSaveException(PaymentSaveException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponse(exception.getMessage()));
    }

    @ExceptionHandler(InvalidParamsException.class)
    public ResponseEntity<?> handlInvalidParamsException(InvalidParamsException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(exception.getMessage()));
    }
}
