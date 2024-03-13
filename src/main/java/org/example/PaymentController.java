package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Payment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class PaymentController {
    @RequestMapping("/")
    public String hello() {
        return "Hello world";
    }

    @RequestMapping("/time")
    public String getTime() {
        return new Date(System.currentTimeMillis()).toString();
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public String paymentProcessing(String payload) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Payment payment = objectMapper.readValue(payload, Payment.class);
        String toPay = payment.getAmount() + "/" + payment.getCurrency();
        pay(toPay);
        return "test";
    }

    private void pay(String payment){
        System.out.println(payment);
    }
}

