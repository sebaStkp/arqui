package com.example.examen;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginRequest;
import com.example.dto.LoginResponse;

import io.sentry.Sentry;

import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

@RestController
public class LoginController implements ILoginController{

    private String generateToken(String email, String password) {
        if (isValidCredentials(email, password)) {
            String token = "token_para_email" + email;
            return token;
        } else {
            throw new RuntimeException("Credenciales de usuario incorrectas");
        }
    }
    
    private boolean isValidCredentials(String email, String password) {
        Boolean respuesta= false;

        String email_valido = "[a-zA-Z0-9._%+-]+@gmail\\.com$";
        String pass_valido = "^[a-zA-Z0-9._]{10,}";

        Pattern pattern_email = Pattern.compile(email_valido);
        Matcher matcher_email = pattern_email.matcher(email);

        Pattern pattern_pass = Pattern.compile(pass_valido);
        Matcher matcher_pass = pattern_pass.matcher(password);

        if (matcher_email.matches() &&  matcher_pass.matches()) {
            System.out.println("El email y contraseña son valido");
            respuesta = true; 
        } else {
            System.out.println("El email y contraseña NO son valido");
        }
        return respuesta;
    }

    @GetMapping("/")
    public String index() {

        try {
            throw new Exception("This is a test.");
          } catch (Exception e) {
            Sentry.captureException(e);
          }
        return "Login Controller from Spring boot";
    }
    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        String token = generateToken(request.getEmail(), request.getPassword());
        LocalDateTime timestamp = LocalDateTime.now();
        LoginResponse response = new LoginResponse(token, timestamp);
        return ResponseEntity.ok(response);
    }


    
}
