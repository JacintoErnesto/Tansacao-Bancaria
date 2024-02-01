/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtor.kafka.produtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import produtor.kafka.produtor.dtos.ContaDto;
import produtor.kafka.produtor.entities.Conta;
import produtor.kafka.produtor.services.ContaService;
import produtor.kafka.produtor.services.TokenService;

/**
 *
 * @author jacinto
 */
@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    @Autowired
    private ContaService contaService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody ContaDto contaDto) {
        Conta contaLogin = this.contaService.login(contaDto);
        if (contaLogin == null) {
            return ResponseEntity.notFound().build() ;
        }
        String token = this.tokenService.gerarToken(contaLogin);
        return ResponseEntity.ok(token) ;
    }

}
