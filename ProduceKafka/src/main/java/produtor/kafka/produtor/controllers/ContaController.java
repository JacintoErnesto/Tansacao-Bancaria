/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtor.kafka.produtor.controllers;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import produtor.kafka.produtor.dtos.ContaDto;
import produtor.kafka.produtor.entities.Conta;
import produtor.kafka.produtor.services.ContaService;

/**
 *
 * @author jacinto
 */
@RestController
@RequestMapping("/conta")
public class ContaController {
    @Autowired
    private ContaService contaService;
    
    @GetMapping("/conta_listar")
    public ResponseEntity<List<Conta>> contaListar(){
        try {
            return ResponseEntity.ok(this.contaService.contaListar());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
   
    
    @PostMapping("/conta_criar")
    public ResponseEntity<Conta> contaCriar(@RequestBody @Valid ContaDto contaDto){
        Conta contaNova = this.contaService.contaCriar(contaDto);
        if (contaNova == null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(contaNova);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(contaNova);
    }
    
    
}
