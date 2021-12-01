package br.edu.ifms.pesquisa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.pesquisa.domain.Campus;
import br.edu.ifms.pesquisa.repository.CampusRepository;
import br.edu.ifms.pesquisa.service.exception.ObjectNotFoundException;

@Service
public class CampusService {
	@Autowired
	private CampusRepository repo;
	
	public Campus buscar(Integer id) {
		Optional<Campus> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Campus.class.getName()));		
	}
}
