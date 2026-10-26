package com.sena.michel.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class UsuarioDto {

    private Long id;

    @NotBlank (message = "El nombre es obligatorio")
    @Size (min = 2 , max = 60,
    message = "El nombre debe tener entre 2 y 60 caracteres"
    )
    private String nomb;

    @NotBlank (message = "El apellido es obligatorio")
    @Size (min = 2 , max = 60,
    message = "El apellido debe tener entre 2 y 60 caracteres"
    )
    private String apell;

    @NotBlank (message = "La dirección es obligatoria")
    @Size (min = 5 , max = 120,
    message = "La dirección debe tener entre 5 y 120 caracteres"
    )
    private String direc;

    @Pattern (regexp = "^[0-9]+$", message = "El teléfono debe contener solo números")
    private Long tele;

}
