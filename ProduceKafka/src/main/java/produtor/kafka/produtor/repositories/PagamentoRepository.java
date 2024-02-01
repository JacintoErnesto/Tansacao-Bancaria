/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package produtor.kafka.produtor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import produtor.kafka.produtor.entities.Pagamento;

/**
 *
 * @author jacinto
 */
public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
    
}
