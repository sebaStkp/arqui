package com.example.dto;

import java.time.LocalDateTime;

public class LoginResponse {
    private String token;
    private LocalDateTime timestamp;

    public LoginResponse(String token, LocalDateTime timestamp) {
        this.token = token;
        this.timestamp = timestamp;
    }

    public String getToken(){
        return token;
    }
    public LocalDateTime getTimesTamp(){
        return timestamp;
    }

    public void setToken(String token_n){
        this.token = token_n;
    }
    public void setTimesTamp(LocalDateTime time_n){
        this.timestamp = time_n;
    }

    
}