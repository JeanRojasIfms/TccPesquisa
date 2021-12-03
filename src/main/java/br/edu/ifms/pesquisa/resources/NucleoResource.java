package br.edu.ifms.pesquisa.resources;

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

import br.edu.ifms.pesquisa.domain.Nucleo;
import br.edu.ifms.pesquisa.dto.NucleoDTO;
import br.edu.ifms.pesquisa.service.NucleoService;


@RestController
@RequestMapping(value = "/nucleo")
public class NucleoResource {
	
	@Autowired
	private NucleoService nucleo;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Nucleo> find(@PathVariable Integer id) {		
		Nucleo obj = nucleo.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody NucleoDTO objDto, @PathVariable Integer id) {
		Nucleo obj = nucleo.fromDTO(objDto);
		obj.setId(id);
		obj = nucleo.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Nucleo obj,@PathVariable Integer id){
		nucleo.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<NucleoDTO>> findAll() {		
		List<Nucleo> list = nucleo.findAll();
		List<NucleoDTO> listDto = list.stream().map(obj -> new NucleoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	

	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<NucleoDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Nucleo> list = nucleo.findPage(page, linesPerPage, orderBy, direction);
		Page<NucleoDTO> listDto = list.map(obj -> new NucleoDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}

}
