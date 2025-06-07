package com.epdms.security.service;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import com.epdms.model.Employee;

import java.util.*;
import java.util.function.Function;
import java.security.Key;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private final String SECRET = "harey_krishna";
    private final long EXPIRATION = 1000 * 60 * 60 * 10; // 10 hours

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(Employee employee) {
        return Jwts.builder()
                .setSubject(employee.getUsername())
                .claim("role", employee.getRole().name())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
        return resolver.apply(claims);
    }

    public boolean validateToken(String token, Employee employee) {
        return extractUsername(token).equals(employee.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
}
