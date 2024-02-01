
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jacinto
 */

package produtor.kafka.produtor.config;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class KafkaConfig {
    
    
    @Value("${topicos.pagamento.request.topic}")
    private String pagamentoRequestTopic;
    
    @Value("${topicos.pagamento.request.topic.resposta}")
    private String pagamentoRequestTopicRespota;

    // Configuração do produtor
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put("bootstrap.servers", "localhost:9092");
        configProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        configProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }


    // Configuração do tópico
    @Bean
    public NewTopic pagamentoRequestTopic() {
        return TopicBuilder
                .name(pagamentoRequestTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }
    
    
    @Bean
    public NewTopic pagamentoRequestTopicResposta() {
        return TopicBuilder
                .name(pagamentoRequestTopicRespota)
                .partitions(1)
                .replicas(1)
                .build();
    }
}

