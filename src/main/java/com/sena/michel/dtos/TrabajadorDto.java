package com.sena.michel.dtos;

import lombok.AllArgsConstructor;
import lombok.SuperBuilder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class TrabajadorDto extends UsuarioDto {

    private String cargo;
    private Double sueldo;

}
