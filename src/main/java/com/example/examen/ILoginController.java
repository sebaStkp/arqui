package com.example.examen;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.dto.LoginRequest;
import com.example.dto.LoginResponse;
import com.example.dto.ErrorResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

public interface ILoginController {

    @Tag(name = "Login", description = "User login")
    @Operation(summary = "User login", description = "punto para autenticacion")
    @ApiResponses(
        value = {
            @ApiResponse(
                responseCode = "200", description = "login exitoso",
                content = {
                    @Content(mediaType = "application/json",
                        schema = @Schema(implementation = LoginResponse.class))
                }
            ),
            @ApiResponse(
                responseCode = "401", description = "Sin autorizacion",
                content = {
                    @Content(mediaType = "application/json",
                        schema = @Schema(implementation = ErrorResponse.class))
                }
            )
        }
    )
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(LoginRequest request);

}
