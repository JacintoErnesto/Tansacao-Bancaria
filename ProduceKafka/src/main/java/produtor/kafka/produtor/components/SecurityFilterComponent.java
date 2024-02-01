/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtor.kafka.produtor.components;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import produtor.kafka.produtor.repositories.ContaRepository;
import produtor.kafka.produtor.services.TokenService;

/**
 *
 * @author jacinto
 */
@Component
public class SecurityFilterComponent extends OncePerRequestFilter{
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ContaRepository contaRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = this.recoverToken(request);
        System.err.println(token);
        if (token != null){
            String login = this.tokenService.validarToken(token);
            System.err.println(login);
            UserDetails user = this.contaRepository.findByUsername(login);
            if (user != null) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if ( authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
    
 }
