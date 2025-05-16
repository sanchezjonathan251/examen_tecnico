package com.prueba.empleados.security;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import com.prueba.empleados.utils.Constants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTAuthtenticationConfig {

    private SecretKey SUPER_SECRET_KEY = Constants.SECRETE_KEY;
    private int jwtExpirationMs = 3600000;

    public String getJWTToken(String username) {
        return Jwts.builder()
                   .setSubject(username)
                   .setIssuedAt(new Date())
                   .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                   .signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY)
                   .compact();
    }
}