package br.edu.ifms.pesquisa.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifms.pesquisa.domain.Campus;
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
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Campus obj){
		obj = campus.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	@RequestMapping(value="/{id}", method= RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Campus obj,@PathVariable Integer id){
		obj.setId(id);
		obj = campus.updade(obj);
		return ResponseEntity.noContent().build();		
	}
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody Campus obj,@PathVariable Integer id){
		campus.delete(id);
		return ResponseEntity.noContent().build();
	}

}
