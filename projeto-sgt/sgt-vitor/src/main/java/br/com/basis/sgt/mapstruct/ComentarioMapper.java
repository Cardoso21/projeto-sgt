package br.com.basis.sgt.mapstruct;

import br.com.basis.sgt.dtos.ComentarioDTO;
import br.com.basis.sgt.entities.Comentario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComentarioMapper extends EntityMapper<Comentario, ComentarioDTO>{

}
