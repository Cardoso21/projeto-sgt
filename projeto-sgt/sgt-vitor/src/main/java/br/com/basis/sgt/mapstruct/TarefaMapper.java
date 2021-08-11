package br.com.basis.sgt.mapstruct;

import br.com.basis.sgt.dtos.TarefaDTO;
import br.com.basis.sgt.entities.Tarefa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TarefaMapper extends EntityMapper<Tarefa, TarefaDTO>{
    @Override
    @Mapping(source = "idResponsavel", target = "responsavel.id")
    Tarefa ToEntity(TarefaDTO dto);

    @Override
    @Mapping(source = "responsavel.id", target = "idResponsavel")
    TarefaDTO ToDto(Tarefa entity);

}
