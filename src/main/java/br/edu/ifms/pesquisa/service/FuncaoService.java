package br.edu.ifms.pesquisa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.pesquisa.domain.Funcao;
import br.edu.ifms.pesquisa.domain.Membro;
import br.edu.ifms.pesquisa.repository.FuncaoRepository;
import br.edu.ifms.pesquisa.service.exception.ObjectNotFoundException;

@Service
public class FuncaoService {
	@Autowired
	private FuncaoRepository repo;
	
	public Funcao find(Integer id) {
		Optional<Funcao> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Membro.class.getName()));		
	}
}
