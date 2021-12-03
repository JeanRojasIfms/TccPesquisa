package br.edu.ifms.pesquisa.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.pesquisa.domain.Campus;
import br.edu.ifms.pesquisa.dto.CampusDTO;
import br.edu.ifms.pesquisa.service.CampusService;


@RestController
@RequestMapping(value = "/campus")
public class CampusResource {
	
	@Autowired
	private CampusService campus;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Campus> find(@PathVariable Integer id) {		
		Campus obj = campus.find(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CampusDTO objDto) {
		Campus obj = campus.fromDTO(objDto);
		obj = campus.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CampusDTO objDto, @PathVariable Integer id) {
		Campus obj = campus.fromDTO(objDto);
		obj.setId(id);
		obj = campus.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Campus obj,@PathVariable Integer id){
		campus.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CampusDTO>> findAll() {		
		List<Campus> list = campus.findAll();
		List<CampusDTO> listDto = list.stream().map(obj -> new CampusDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<CampusDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Campus> list = campus.findPage(page, linesPerPage, orderBy, direction);
		Page<CampusDTO> listDto = list.map(obj -> new CampusDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}

}
