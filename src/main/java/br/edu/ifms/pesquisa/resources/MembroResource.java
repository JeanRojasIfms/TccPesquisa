package br.edu.ifms.pesquisa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.pesquisa.domain.Membro;
import br.edu.ifms.pesquisa.service.MembroService;


@RestController
@RequestMapping(value = "/membro")
public class MembroResource {
	
	@Autowired
	private MembroService membro;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Membro obj = membro.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
