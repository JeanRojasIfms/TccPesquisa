package br.edu.ifms.pesquisa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.pesquisa.domain.Discente;
import br.edu.ifms.pesquisa.domain.Membro;
import br.edu.ifms.pesquisa.repository.DiscenteRepository;
import br.edu.ifms.pesquisa.service.exception.ObjectNotFoundException;

@Service
public class DiscenteService {
	@Autowired
	private DiscenteRepository repo;
	
	public Discente find(Integer id) {
		Optional<Discente> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Membro.class.getName()));		
	}
}
