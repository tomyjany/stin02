package org.example.services;

import org.example.models.Payment;
import org.springframework.stereotype.Component;

@Component
public class CardPaymentService implements IPaymentService {
    private final PaymentServiceProcessing paymentServiceProcessing;

    public CardPaymentService(PaymentServiceProcessing paymentServiceProcessing) {
        this.paymentServiceProcessing = paymentServiceProcessing;
    }

    @Override
    public void processPayment(Payment payment) {
        String toPay = payment.getAmount() + "/" + payment.getCurrency();
        paymentServiceProcessing.pay(toPay);
    }
}