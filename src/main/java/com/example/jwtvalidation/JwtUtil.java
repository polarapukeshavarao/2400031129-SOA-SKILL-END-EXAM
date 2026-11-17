package com.example.jwtvalidation;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private static final String SECRET =
            "mysecretkey012345678901234567890";

    private final Key signingKey = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String username) {
        long now = System.currentTimeMillis();

        return Jwts.builder()
                .subject(username)
                .claim("role", "STUDENT")
                .claim("college", "KL University")
                .issuedAt(new Date(now))
                .expiration(new Date(now + 60 * 60 * 1000)) // 1 hour
                .signWith(signingKey)
                .compact();
    }

    public Claims validateTokenAndGetClaims(String token) {
        return Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) signingKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
