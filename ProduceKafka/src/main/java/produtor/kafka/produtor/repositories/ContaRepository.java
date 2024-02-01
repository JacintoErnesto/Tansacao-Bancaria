/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package produtor.kafka.produtor.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import produtor.kafka.produtor.entities.Conta;

/**
 *
 * @author jacinto
 */
public interface ContaRepository extends JpaRepository<Conta, Long>{

    public Conta findByPkConta(Long pkConta);

    public Conta findByUsername(String username);

    public List<Conta> findAllByOrderByUsername();
    
}
