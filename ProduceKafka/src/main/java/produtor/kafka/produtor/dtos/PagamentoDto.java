/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package produtor.kafka.produtor.dtos;

import java.math.BigDecimal;

/**
 *
 * @author jacinto
 */
public record PagamentoDto(String descricao, BigDecimal valor) {

}
