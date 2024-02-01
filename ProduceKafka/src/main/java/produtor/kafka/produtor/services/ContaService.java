/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package produtor.kafka.produtor.services;

import java.util.List;
import org.springframework.stereotype.Service;
import produtor.kafka.produtor.dtos.ContaDto;
import produtor.kafka.produtor.entities.Conta;

/**
 *
 * @author jacinto
 */
@Service
public interface ContaService {
    public Conta contaCriar(ContaDto contaDto);
    public List<Conta> contaListar();
    public Conta login(ContaDto contaDto);
    
}
