package br.edu.ifms.pesquisa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.pesquisa.domain.Campus;
import br.edu.ifms.pesquisa.domain.Nucleo;
import br.edu.ifms.pesquisa.repository.NucleoRepository;
import br.edu.ifms.pesquisa.service.exception.ObjectNotFoundException;

@Service
public class NucleoService {
	@Autowired
	private NucleoRepository repo;
	
	public Nucleo find(Integer id) {
		Optional<Nucleo> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Campus.class.getName()));		
	}
}
