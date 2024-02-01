/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtor.kafka.produtor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import produtor.kafka.produtor.dtos.PagamentoDto;
import produtor.kafka.produtor.services.PagamentoService;



/**
 *
 * @author jacinto
 */
@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;
    
    @GetMapping
    public String hell(){
        return "oi";
    }
    
    @PostMapping("/postPagamento")
    public String pagamento(@RequestBody PagamentoDto pagamentoDto){
        return pagamentoService.integrarPagamento(pagamentoDto);
    }
    
}
