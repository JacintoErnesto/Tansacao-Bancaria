package produtor.kafka.produtor.entities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author jacinto
 */
@Entity(name = "Pagamento")
@Table(name = "pagamento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_pagamento")
    private Long pkPagamento;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "valor")
    private BigDecimal valor;
    @ManyToOne
    private Conta fkConta;
}
