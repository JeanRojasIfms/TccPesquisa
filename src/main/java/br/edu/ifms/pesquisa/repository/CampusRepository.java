package br.edu.ifms.pesquisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.pesquisa.domain.Campus;
@Repository
public interface CampusRepository extends JpaRepository<Campus, Integer>{

}
