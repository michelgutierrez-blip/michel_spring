package com.sena.michel.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sena.michel.dtos.TrabajadorDto;
import com.sena.michel.models.usuarios.Trabajador;

@Mapper (componentModel = "spring")
public interface TrabajadorMapper {

    // convierte de Entidad a DTO
    // Trabajador a TrabajadorDto
    @Mapping (source = "nomb", target = "nom")
    @Mapping (source = "apell", target = "ape")
    @Mapping (source = "direc", target = "dir")
    @Mapping (source = "tele", target = "tel")
    Trabajador toEntity(TrabajadorDto trabajadorDto);

    //Convierte de DTO a Entidad
    //TrabajadorDto a Trabajador
    @Mapping (source = "nom", target = "nomb")
    @Mapping (source = "ape", target = "apell")
    @Mapping (source = "dir", target = "direc")
    @Mapping (source = "tel", target = "tele")
    TrabajadorDto toDto(Trabajador trabajador);
}
