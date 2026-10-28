package com.sena.michel.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.sena.michel.dtos.UsuarioDto;
import com.sena.michel.models.usuarios.Usuario;

@Mapper (componentModel = "spring")
public interface UsuarioMapper {

    //convertir de Entidad a DTO

    @Mapping (source = "nom", target = "nomb")
    @Mapping (source = "ape", target = "apell")
    @Mapping (source = "dir", target = "direc")
    @Mapping (source = "tel", target = "tele")
    UsuarioDto convierteaDto(Usuario usuario);

    //convertir de DTO a Entidad

    @Mapping (source = "nomb", target = "nom")
    @Mapping (source = "apell", target = "ape")
    @Mapping (source = "direc", target = "dir")
    @Mapping (source = "tele", target = "tel")
    Usuario convierteaEntidad(UsuarioDto usuarioDto);
}

