package com.sena.michel.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sena.michel.dtos.TrabajadorDto;
import com.sena.michel.dtos.TrabajadorDtoResponse;
import com.sena.michel.models.usuarios.Trabajador;

@Mapper (componentModel = "spring")
public interface TrabajadorMapper {

    //Convierte de DTO a Entidad
    //TrabajadorDto a Trabajador
    @Mapping (source = "nomb", target = "nom")
    @Mapping (source = "apell", target = "ape")
    @Mapping (source = "direc", target = "dir")
    @Mapping (source = "tele", target = "tel")
// para cargo el seervice se n¿encargara de buscarlo y asignarlo 
    @Mapping (target = "carTraba", ignore = true)// AQUI: le dice a MapStruct
    Trabajador toEntity(TrabajadorDto trabajadorDto); 

    // convierte de Entidad a DTO
    // Trabajador a TrabajadorDto
    @Mapping (source = "nom", target = "nomb")
    @Mapping (source = "ape", target = "apell")
    @Mapping (source = "dir", target = "direc")
    @Mapping (source = "tel", target = "tele")
    @Mapping (source = "carTraba.cargoTrab", target = "cargo")
    TrabajadorDtoResponse toDto(Trabajador trabajador);
}
