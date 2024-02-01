/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtor.kafka.produtor.services.Impls;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import produtor.kafka.produtor.dtos.PagamentoDto;
import produtor.kafka.produtor.entities.Conta;
import produtor.kafka.produtor.entities.Pagamento;
import produtor.kafka.produtor.producers.PagamentoKafkaProducer;
import produtor.kafka.produtor.repositories.ContaRepository;
import produtor.kafka.produtor.services.PagamentoService;

/**
 *
 * @author jacinto
 */
@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoKafkaProducer pagamentoKafkaProducer;
    @Autowired
    private ContaRepository contaRepository;

    @Override
    public String integrarPagamento(PagamentoDto pagamentoDto) {
        try {
            //Conta fkConta = this.contaRepository.findByPkConta(pagamentoDto.pkConta());
            Pagamento pagamento = new Pagamento();
            pagamento.setDescricao(pagamentoDto.descricao());
            pagamento.setValor(pagamentoDto.valor());
            //pagamento.setFkConta(fkConta);
            return pagamentoKafkaProducer.sendMessage(pagamentoDto);
        } catch (JsonProcessingException e) {
            return "Houve um erro ao solicitar pagamento" + e.getMessage();
        }
    }

}
