/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consumer.kafka.consumer.consumer_kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import consumer.kafka.consumer.entities.PagamentoFeito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author jacinto
 */
@Service
public class ConsumerKafka {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${topicos.pagamento.request.topic.resposta}")
    private String pagamentoRequestTopicRespota;

    @KafkaListener(
            topics = "${topicos.pagamento.request.topic}",
            groupId = "pagamento-request-consumer-1"
    )

    public void consume(String message) {
        try {
            // Converte a mensagem JSON para o objeto PagamentoRequest
            ObjectMapper objectMapper = new ObjectMapper();
            PagamentoFeito pagamentoFeito = objectMapper.readValue(message, PagamentoFeito.class);
            System.err.println("Pagamento"+pagamentoFeito);
            System.err.println("1");
            String resposta = "Mensagem recebida: " + pagamentoFeito.toString();
            kafkaTemplate.send(pagamentoRequestTopicRespota, resposta);
            System.err.println(pagamentoRequestTopicRespota);
            System.err.println("Resposta"+resposta);
            // Se precisar de mais lógica de manipulação, você pode implementar métodos no objeto PagamentoRequest
            // e chamar esses métodos aqui antes de salvar no banco de dados.
        } catch (Exception e) {
            // Lida com exceções de desserialização ou erros no processamento da mensagem
            System.err.println("Erro ao processar a mensagem: " + e.getMessage());
        }
    }
}
