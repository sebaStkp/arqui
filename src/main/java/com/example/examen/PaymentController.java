package com.example.examen;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PaymentRequest;
import com.example.dto.PaymentResponse;


import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@Tag(name = "Payment", description = "Credit card payment API")
public class PaymentController implements IPaymentApi{

    @PostMapping("/payment")
    public ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest request) {
        PaymentResponse response = new PaymentResponse(0, "Successful");
        return ResponseEntity.ok(response);
    }
}
