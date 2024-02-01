/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtor.kafka.produtor.producers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import produtor.kafka.produtor.dtos.PagamentoDto;
import produtor.kafka.produtor.services.RespostaConsumerService;

/**
 *
 * @author jacinto
 */
@Service
public class PagamentoKafkaProducer {
    
    @Value("${topicos.pagamento.request.topic}")
    private String pagamentoRequestTopic;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private RespostaConsumerService respostaConsumerService;
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    public String sendMessage(PagamentoDto pagamentoDto) throws JsonProcessingException{
        String conteudo = objectMapper.writeValueAsString(pagamentoDto);
        kafkaTemplate.send(pagamentoRequestTopic, conteudo);
        return "Pagamento enviado para o processamento";
    }
}
