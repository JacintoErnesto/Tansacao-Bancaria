/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtor.kafka.produtor.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import produtor.kafka.produtor.entities.Conta;

/**
 *
 * @author jacinto
 */
@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Conta conta) {

        try {

            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("api-token")
                    .withSubject(conta.getUsername())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generating token", e);
        }
    }

    public String validarToken(String token) {
        System.err.println(token);
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
             System.err.println(algorithm);
            return JWT.require(algorithm)
                    .withIssuer("api-token")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException e) {

            return "";
        }
    }

    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.UTC);
    }

}
