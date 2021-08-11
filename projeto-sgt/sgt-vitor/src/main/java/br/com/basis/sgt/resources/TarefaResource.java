package br.com.basis.sgt.resources;

import br.com.basis.sgt.dtos.TarefaDTO;
import br.com.basis.sgt.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/tarefas")
@CrossOrigin()
public class TarefaResource {

	
	@Autowired
	private TarefaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TarefaDTO> findById(@PathVariable Long id){
		TarefaDTO tarefa = service.findById(id);
		return ResponseEntity.ok(tarefa);
	}
	
	@GetMapping
	public ResponseEntity<Page<TarefaDTO>> findAllPaged(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "10") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "dataInicial") String orderBy){
		
		PageRequest request = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);	
		Page<TarefaDTO> pages = service.findAllPage(request);
		return ResponseEntity.ok(pages);
		
	}
	
	@PostMapping
	public ResponseEntity<TarefaDTO> insert(@RequestBody @Valid TarefaDTO dto){
		dto = service.salvar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<TarefaDTO> update(@PathVariable Long id, @RequestBody @Valid TarefaDTO dto){
		dto.setId(id);
		dto = service.salvar(dto);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
