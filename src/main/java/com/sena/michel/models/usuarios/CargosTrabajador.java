package com.sena.michel.models.usuarios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity 
@Table (name= "cargo_trabajador")
@Getter 
@NoArgsConstructor 
public class CargosTrabajador {
    @Id
    private Byte id;

    @Column (nullable = false, unique = true, length = 30)
    private String cargoTrab;
}
