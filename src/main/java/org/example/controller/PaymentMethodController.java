package org.example.controller;

import org.example.main.PaymentMethod;
import org.example.main.patterns.Strategy.PaymentStrategy;
import org.example.repository.PaymentMethodRepository;

import java.util.List;


public class PaymentMethodController {
    private PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodController(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public void createPaymentMethod(int paymentId,  String status, PaymentStrategy paymentStrategy) {
        PaymentMethod paymentMethod = new PaymentMethod(paymentId, status,paymentStrategy);
        paymentMethodRepository.save(paymentMethod);
    }

    public PaymentMethod findPaymentMethodById(int paymentMethodId) {
        return paymentMethodRepository.findById(paymentMethodId);
    }

    public List<PaymentMethod> viewAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    public void updatePaymentMethod(int paymentMethodId,  String status,PaymentStrategy paymentStrategy) {
        PaymentMethod updatedPaymentMethod = new PaymentMethod(paymentMethodId, status,paymentStrategy);
        paymentMethodRepository.update(updatedPaymentMethod);
    }



    public void deletePaymentMethod(int paymentMethodId) {
        paymentMethodRepository.delete(paymentMethodId);
    }


}
