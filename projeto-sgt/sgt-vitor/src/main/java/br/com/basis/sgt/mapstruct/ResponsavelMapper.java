package br.com.basis.sgt.mapstruct;

import br.com.basis.sgt.dtos.ResponsavelDTO;
import br.com.basis.sgt.entities.Responsavel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponsavelMapper extends EntityMapper<Responsavel, ResponsavelDTO>{
}
