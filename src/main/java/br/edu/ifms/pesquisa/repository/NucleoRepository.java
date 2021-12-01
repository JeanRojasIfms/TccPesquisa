package br.edu.ifms.pesquisa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifms.pesquisa.domain.Nucleo;
@Repository
public interface NucleoRepository extends JpaRepository<Nucleo, Integer>{

}
