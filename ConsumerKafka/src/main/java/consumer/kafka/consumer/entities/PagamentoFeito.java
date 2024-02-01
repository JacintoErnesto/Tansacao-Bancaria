/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consumer.kafka.consumer.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jacinto
 */
@Entity(name = "PagamentoFeito")
@Table(name = "pagamento_feito")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagamentoFeito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_pagamento_feito")
    private int pkPagamentoFeito;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "valor")
    private BigDecimal valor;
    
}
