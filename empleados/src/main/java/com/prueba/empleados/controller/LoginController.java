package com.prueba.empleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.empleados.security.JWTAuthtenticationConfig;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/security/")
@Tag(name = "Loggin", description = "Servicio para el logeo al api")
public class LoginController {

    @Autowired
    JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @PostMapping("login")
    @Operation(summary = "Metodo para el loggin", description = "Recibe los parametros usuario y password para retornar un JWT")
    public String login(
            @RequestParam("usuario") String username,
            @RequestParam("password") String encryptedPass) {

        if (isValidUser(username, encryptedPass)) {
            String token = jwtAuthtenticationConfig.getJWTToken(username);
            return token;
        } else {
            throw new RuntimeException("Credenciales inválidas");
        }
    }

    private boolean isValidUser(String username, String encryptedPass) {
        return "usuario".equals(username) && "password".equals(encryptedPass);
    }
}