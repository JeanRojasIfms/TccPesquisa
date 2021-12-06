package br.edu.ifms.pesquisa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifms.pesquisa.domain.Noticia;
import br.edu.ifms.pesquisa.domain.Nucleo;
import br.edu.ifms.pesquisa.dto.NucleoDTO;
import br.edu.ifms.pesquisa.dto.NucleoNewDTO;
import br.edu.ifms.pesquisa.repository.NoticiaRepository;
import br.edu.ifms.pesquisa.repository.NucleoRepository;
import br.edu.ifms.pesquisa.service.exception.DataIntegrityException;
import br.edu.ifms.pesquisa.service.exception.ObjectNotFoundException;

@Service
public class NucleoService {
	@Autowired
	private NucleoRepository repo;
	@Autowired
	private NoticiaRepository noticia;
	
	public Nucleo find(Integer id) {
		Optional<Nucleo> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Nucleo.class.getName()));		
	}
	
	@Transactional
	public Nucleo insert (Nucleo obj) {
		obj.setId(null);
		repo.save(obj);
		noticia.saveAll(obj.getNoticias());
		return obj;
		
	}
	
	public Nucleo update(Nucleo obj) {
		Nucleo newObj = find(obj.getId());
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

	public List<Nucleo> findAll() {
		// TODO Auto-generated method stub		
		return repo.findAll();
	}
	
	public Page<Nucleo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Nucleo fromDTO(NucleoDTO objDto) {
		return new Nucleo(objDto.getId(), objDto.getNome(),objDto.getPathBanner(),objDto.getDescricao(),null);
	}
	
	public Nucleo fromDTO(NucleoNewDTO objDto) {
		Nucleo nuc = new Nucleo(null, objDto.getNome(),objDto.getPathBanner(), objDto.getDescricao(),null);
		Noticia not = new Noticia(null, objDto.getTitulo(), objDto.getInstante(), objDto.getNoticia(), nuc);
		nuc.getNoticias().add(not);
		return nuc;
	}
	
	private void updateData(Nucleo newObj, Nucleo obj) {
		newObj.setNome(obj.getNome());
		newObj.setPathBanner(obj.getPathBanner());
		newObj.setDescricao(obj.getDescricao());
	}
}
