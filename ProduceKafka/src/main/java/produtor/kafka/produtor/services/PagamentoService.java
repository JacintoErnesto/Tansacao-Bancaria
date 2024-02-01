/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package produtor.kafka.produtor.services;

import produtor.kafka.produtor.dtos.PagamentoDto;

/**
 *
 * @author jacinto
 */
public interface PagamentoService {
    String integrarPagamento(PagamentoDto pagamentoDto);
}
