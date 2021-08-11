package br.com.basis.sgt.resources;

import br.com.basis.sgt.dtos.ResponsavelDTO;
import br.com.basis.sgt.services.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/responsaveis")
@CrossOrigin()
public class ResponsavelResource {

	
	@Autowired
	private ResponsavelService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponsavelDTO> findById(@PathVariable Long id){
		ResponsavelDTO responsavelDTO = service.findById(id);
		return ResponseEntity.ok(responsavelDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<ResponsavelDTO>> findAll(){
		List<ResponsavelDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<ResponsavelDTO> insert(@RequestBody @Valid ResponsavelDTO dto){
		dto = service.salvar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ResponsavelDTO> update(@PathVariable Long id, @RequestBody @Valid ResponsavelDTO dto){
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
