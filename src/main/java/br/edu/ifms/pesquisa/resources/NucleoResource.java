package br.edu.ifms.pesquisa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.pesquisa.domain.Nucleo;
import br.edu.ifms.pesquisa.service.NucleoService;


@RestController
@RequestMapping(value = "/nucleo")
public class NucleoResource {
	
	@Autowired
	private NucleoService nucleo;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Nucleo obj = nucleo.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

}
