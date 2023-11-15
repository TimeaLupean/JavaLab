package org.example.main.patterns.Strategy;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Processing cash payment");
    }

    @Override
    public String getPaymentType() {
        return "Cash";
    }
}
