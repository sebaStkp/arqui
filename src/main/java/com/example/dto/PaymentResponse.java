package com.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Response for credit card payment processing")
public class PaymentResponse {
    
    @Schema(description = "Status code indicando el resultado del proceso payment")
    private int statusCode;

    @Schema(description = "El mensaje proporciona información adicional sobre el resultado del pago")
    private String message;

    public PaymentResponse() {
    }

    public PaymentResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

