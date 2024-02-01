/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtor.kafka.produtor.dtos;

import jakarta.validation.constraints.NotBlank;
import produtor.kafka.produtor.enums.RoleEnum;

/**
 *
 * @author jacinto
 */
public record ContaDto(@NotBlank String username,@NotBlank String password, RoleEnum rouleEnum) {
    
}
