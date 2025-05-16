package com.prueba.empleados.utils;

import javax.crypto.SecretKey;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class Constants {
    public static final String LOGIN_URL = "/login"; 
    public static final String REGISTER_URL = "/truper"; 
    public static final SecretKey SECRETE_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
}