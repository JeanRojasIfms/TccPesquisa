package br.edu.ifms.pesquisa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.pesquisa.domain.Membro;
import br.edu.ifms.pesquisa.repository.MembroRepository;
import br.edu.ifms.pesquisa.service.exception.ObjectNotFoundException;

@Service
public class MembroService {
	@Autowired
	private MembroRepository repo;
	
	public Membro buscar(Integer id) {
		Optional<Membro> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Membro.class.getName()));		
	}
}
