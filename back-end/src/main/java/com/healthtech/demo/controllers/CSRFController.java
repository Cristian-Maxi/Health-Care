package com.healthtech.demo.controllers;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CSRFController {
    
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(CsrfToken token) {
        System.out.println("CSRF Token Requested: " + token.getToken());
        return token;
    }
}
