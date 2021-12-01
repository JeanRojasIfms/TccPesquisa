package br.edu.ifms.pesquisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.pesquisa.domain.Funcao;
@Repository
public interface FuncaoRepository extends JpaRepository<Funcao, Integer>{

}
