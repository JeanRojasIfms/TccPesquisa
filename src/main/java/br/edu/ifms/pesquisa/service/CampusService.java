package br.edu.ifms.pesquisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.edu.ifms.pesquisa.domain.Campus;
import br.edu.ifms.pesquisa.dto.CampusDTO;
import br.edu.ifms.pesquisa.repository.CampusRepository;
import br.edu.ifms.pesquisa.service.exception.DataIntegrityException;
import br.edu.ifms.pesquisa.service.exception.ObjectNotFoundException;

@Service
public class CampusService {
	@Autowired
	private CampusRepository repo;
	
	public Campus find(Integer id) {
		Optional<Campus> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Campus.class.getName()));		
	}
	
	public Campus insert (Campus obj) {
		obj.setId(null);
		return repo.save(obj);
		
	}

	public Campus update(Campus obj) {
		Campus newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		find(id);
		try {
			repo.deleteById(id);	
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover. Verifique a integridade referencial.");
		}
	}

	public List<Campus> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	public Page<Campus> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Campus fromDTO(CampusDTO objDto) {
		return new Campus(objDto.getId(), objDto.getNome(),objDto.getPathBanner(),objDto.getPathLogo());
	}
	
	private void updateData(Campus newObj, Campus obj) {
		newObj.setNome(obj.getNome());
		newObj.setPathBanner(obj.getPathBanner());
		newObj.setPathLogo(obj.getPathLogo());
	}
}
