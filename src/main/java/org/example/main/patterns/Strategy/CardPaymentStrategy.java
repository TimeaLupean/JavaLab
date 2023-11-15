package org.example.main.patterns.Strategy;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment() {
        System.out.println("Processing card payment");
    }

    @Override
    public String getPaymentType() {
        return "Card";
    }
}



