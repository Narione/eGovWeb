package egovframework.example.login.service;

import lombok.Data;

@Data
public class LoginRequest {
    private String id;
    private String password;
}
