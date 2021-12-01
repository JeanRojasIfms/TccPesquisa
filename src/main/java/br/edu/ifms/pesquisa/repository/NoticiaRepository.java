package br.edu.ifms.pesquisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.pesquisa.domain.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Integer>{

}
