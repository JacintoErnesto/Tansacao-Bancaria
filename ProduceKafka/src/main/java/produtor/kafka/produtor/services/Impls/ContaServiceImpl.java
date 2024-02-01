/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package produtor.kafka.produtor.services.Impls;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import produtor.kafka.produtor.dtos.ContaDto;
import produtor.kafka.produtor.entities.Conta;
import produtor.kafka.produtor.repositories.ContaRepository;
import produtor.kafka.produtor.services.ContaService;

/**
 *
 * @author jacinto
 */
@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public Conta contaCriar(ContaDto contaDto) {

        Conta validarConta = this.contaRepository.findByUsername(contaDto.username());
        if (validarConta == null) {
            Conta contaNova = new Conta();
            contaNova.setUsername(contaDto.username());
            contaNova.setPassword(passwordEncoder().encode(contaDto.password()));
            contaNova.setRoleEnum(contaDto.rouleEnum());
            return this.contaRepository.save(contaNova);
        }

        return null;
    }

    @Override
    public List<Conta> contaListar() {
        return this.contaRepository.findAllByOrderByUsername();
    }

    @Override
    public Conta login(ContaDto contaDto) {
       
        try {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                    = new UsernamePasswordAuthenticationToken(contaDto.username(), contaDto.password());

            Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            Conta conta = (Conta) authentication.getPrincipal();
            return conta;

        } catch (Exception e) {
          
            return null;
        }

    }
}
