package com.example.examen;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.dto.ErrorResponse;
import com.example.dto.PaymentRequest;
import com.example.dto.PaymentResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;

@Tag(name = "Payment", description = "Credit card payment API")
public interface IPaymentApi {

    @Operation(summary = "Process credit card payment", description = "Endpoint for processing credit card payments")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successful payment",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = PaymentResponse.class))),
        @ApiResponse(responseCode = "400", description = "Bad request",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorResponse.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized",
                content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/payment")
    ResponseEntity<PaymentResponse> processPayment(@RequestBody PaymentRequest request);
}
