package org.example.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.models.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentTransformations {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final XmlMapper xmlMapper = new XmlMapper();



    public Payment transformJsonIntoPayment(String payload) throws JsonProcessingException {
        return objectMapper.readValue(payload, Payment.class);
    }

    public String transformXMLFromPayment(Payment payment) throws JsonProcessingException{
        return xmlMapper.writeValueAsString(payment);
    }
}
