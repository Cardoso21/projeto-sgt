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
import java.util.List;

@RestController
@RequestMapping(value = "/tarefas")
@CrossOrigin("*")
public class TarefaResource {

	
	@Autowired
	private TarefaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TarefaDTO> findById(@PathVariable Long id){
		TarefaDTO tarefa = service.findById(id);
		return ResponseEntity.ok(tarefa);
	}
	
	@GetMapping
	public ResponseEntity<List<TarefaDTO>> findAll(){

		List<TarefaDTO> list = service.findAll();
		return ResponseEntity.ok(list);
		
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
