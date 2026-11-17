
package com.example.jwtvalidation;

import org.springframework.web.bind.annotation.*;

import io.jsonwebtoken.JwtException;

@RestController
public class JwtController {

    private final JwtUtil jwtUtil;

    public JwtController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam String token) {

        try {
            jwtUtil.validateTokenAndGetClaims(token);
            return "Token is VALID";
        } catch (JwtException | IllegalArgumentException e) {
            return "Token is INVALID";
        }
    }
}
