package br.com.basis.sgt.services;

import br.com.basis.sgt.dtos.TarefaDTO;
import br.com.basis.sgt.entities.Tarefa;
import br.com.basis.sgt.mapstruct.TarefaMapper;
import br.com.basis.sgt.repositories.TarefaRepository;
import br.com.basis.sgt.services.exceptions.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TarefaService {
	
	@Autowired
	private TarefaRepository repository;

	private static final Logger LOGGER = LoggerFactory.getLogger(TarefaService.class);
	
	@Autowired
	private TarefaMapper tarefaMapper;
	
	@Transactional(readOnly = true)
	public TarefaDTO findById(Long id) {
		Optional<Tarefa> tarefa = repository.findById(id);
		Tarefa entity = tarefa.orElseThrow(() -> new ObjectNotFoundException("Tarefa não encontrada"));
		TarefaDTO dto = tarefaMapper.ToDto(entity);
		return dto;
	}

	@Transactional(readOnly = true)
	public Page<TarefaDTO> findAllPage(Pageable pageable) {
		Page<Tarefa> list = repository.findAll(pageable);
		Page<TarefaDTO> pageDTO = list.map( t -> tarefaMapper.ToDto(t));
		return pageDTO;
	}

	@Transactional
	public TarefaDTO salvar(TarefaDTO dto) {
		Tarefa entity = tarefaMapper.ToEntity(dto);
		entity = repository.save(entity);
		return tarefaMapper.ToDto(entity);
	}
		
	public void delete(Long id) {
		try {			
			repository.deleteById(id);
		}catch ( EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Tarefa não encontrada");
		}
	}
	
}
