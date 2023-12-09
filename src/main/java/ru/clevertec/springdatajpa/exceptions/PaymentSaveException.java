package ru.clevertec.springdatajpa.exceptions;

public class PaymentSaveException extends RuntimeException{
    public PaymentSaveException(String message) {
        super(message);
    }
}
