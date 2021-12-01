package br.edu.ifms.pesquisa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifms.pesquisa.domain.Campus;
import br.edu.ifms.pesquisa.domain.Nucleo;
import br.edu.ifms.pesquisa.repository.CampusRepository;
import br.edu.ifms.pesquisa.repository.NucleoRepository;

@SpringBootApplication
public class PesquisaApplication implements CommandLineRunner{
	@Autowired
	private CampusRepository campusRepository;
	@Autowired
	private NucleoRepository nucleoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PesquisaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Campus cam1 = new Campus(null, "IFMS","caminho do banner IFMS","caminho do logo do IFMS");
		Campus cam2 = new Campus(null, "UFMS","caminho banner UFMS","caminho do logo do UFMS");
		
		Nucleo nuc1 = new Nucleo(null,"Nucleo Java", "banner do nucleo java", "pesquisas e tcc em java", cam1);
		Nucleo nuc2 = new Nucleo(null, "Nucleo PHP", "banner do nucleo PHP", "pesquisas e tcc em php", cam1);
		Nucleo nuc3 = new Nucleo(null, "Nucleo Pedagogico", "banner do nucleo pedagogico", "Pesquisas pedagogicas", cam2);
		
		cam1.getNucleos().addAll(Arrays.asList(nuc1,nuc2));
		cam2.getNucleos().addAll(Arrays.asList(nuc3));
		
		campusRepository.saveAll(Arrays.asList(cam1,cam2));
		nucleoRepository.saveAll(Arrays.asList(nuc1,nuc2,nuc3));
	}

}
