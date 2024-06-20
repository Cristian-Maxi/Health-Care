package com.healthtech.demo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.healthtech.demo.entities.Usuario;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    private static final long EXPIRATION_TIME = 7200000; // 2 horas en milisegundos

    public String generarToken(Usuario usuario, String rol) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            Instant expirationTime = generarFechaExpiracion();
            String token = JWT.create()
                    .withIssuer("mediHelp")
                    .withSubject(usuario.getUsuario())
                    .withClaim("id", usuario.getId())
                    .withClaim("role", rol) // Añadir el rol al token
                    .withExpiresAt(expirationTime)
                    .sign(algorithm);

            System.out.println("Generated JWT Token: " + token);
            System.out.println("Token Expiration Time (Instant): " + expirationTime);
            System.out.println("Token Expiration Time (LocalDateTime): " + LocalDateTime.ofInstant(expirationTime, ZoneOffset.UTC));

            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error al crear el token JWT", exception);
        }
    }

    public String getSubject(String token) {
        if (token == null) {
            throw new RuntimeException("El token no puede ser nulo");
        }
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret); // validando firma
            DecodedJWT verifier = JWT.require(algorithm)
                    .withIssuer("mediHelp")
                    .build()
                    .verify(token);

            System.out.println("Verified JWT Token: " + token);
            System.out.println("Verified JWT Subject: " + verifier.getSubject());
            System.out.println("Token Expiration Time (Instant): " + verifier.getExpiresAt().toInstant());
            System.out.println("Token Expiration Time (LocalDateTime): " + LocalDateTime.ofInstant(verifier.getExpiresAt().toInstant(), ZoneOffset.UTC));

            return verifier.getSubject();
        } catch (TokenExpiredException e) {
            System.out.println("Token Expired: " + token);
            throw new RuntimeException("Token JWT inválido: El token ha expirado.", e);
        } catch (JWTVerificationException e) {
            throw new RuntimeException("Token JWT inválido: Error de verificación.", e);
        }
    }

//El Hijo de perra que me estaba dando problemas
//    private Instant generarFechaExpiracion() {
//        Instant expirationTime = LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.UTC);
//        System.out.println("Generated Expiration Time (Instant): " + expirationTime);
//        System.out.println("Generated Expiration Time (LocalDateTime): " + LocalDateTime.ofInstant(expirationTime, ZoneOffset.UTC));
//        return expirationTime;
//    }
    private Instant generarFechaExpiracion() {
        return LocalDateTime.now(ZoneOffset.UTC).plusHours(2).toInstant(ZoneOffset.UTC);
    }
}
