package br.edu.ifms.pesquisa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.pesquisa.domain.Discente;
import br.edu.ifms.pesquisa.service.DiscenteService;


@RestController
@RequestMapping(value = "/discente")
public class DiscenteResource {
	
	@Autowired
	private DiscenteService discente;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Discente obj = discente.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
