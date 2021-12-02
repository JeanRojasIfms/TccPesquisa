package br.edu.ifms.pesquisa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.pesquisa.domain.Funcao;
import br.edu.ifms.pesquisa.service.FuncaoService;


@RestController
@RequestMapping(value = "/funcao")
public class FuncaoResource {
	
	@Autowired
	private FuncaoService funcao;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Funcao> find(@PathVariable Integer id) {
		
		Funcao obj = funcao.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
