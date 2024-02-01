/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtor.kafka.produtor.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 *
 * @author jacinto
 */
@Service
public class RespostaConsumerService {
    
    @KafkaListener(
        topics = "${topicos.pagamento.request.topic.resposta}",
        groupId = "resposta-consumer-group"
    )
    
    public void consumeResposta(String resposta) {
        // Lógica para processar a resposta recebida
        System.out.println("Resposta recebida: " + resposta);
    }
}
