package com.clinic.management.infra.domain.controller;

import com.clinic.management.infra.service.auth.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthController
{
    private final AuthService authService;

    public AuthController(AuthService authService)
    {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request)
    {
        String email = request.get("email");
        String senha = request.get("senha");

        try
        {
            String token = authService.login(email, senha);
            return ResponseEntity.ok(Map.of("token", token));
        } catch (Exception e)
        {
            return ResponseEntity.status(401).body(Map.of("error", "Credenciais inválidas"));
        }
    }
}
