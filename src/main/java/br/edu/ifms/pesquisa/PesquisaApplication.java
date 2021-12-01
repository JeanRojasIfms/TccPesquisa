package br.edu.ifms.pesquisa;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifms.pesquisa.domain.Campus;
import br.edu.ifms.pesquisa.domain.Noticia;
import br.edu.ifms.pesquisa.domain.Nucleo;
import br.edu.ifms.pesquisa.repository.CampusRepository;
import br.edu.ifms.pesquisa.repository.NoticiaRepository;
import br.edu.ifms.pesquisa.repository.NucleoRepository;

@SpringBootApplication
public class PesquisaApplication implements CommandLineRunner{
	@Autowired
	private CampusRepository campusRepository;
	@Autowired
	private NucleoRepository nucleoRepository;
	@Autowired
	private NoticiaRepository noticiaRepository;
	
	
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
		//nucleoRepository.saveAll(Arrays.asList(nuc1,nuc2,nuc3));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Noticia not1 = new Noticia(null, "Titulo da noticia 1", sdf.parse("01/12/2021 10:32"), "corpo da noticia 1 - Java", nuc1);
		Noticia not2 = new Noticia(null, "Titulo da noticia 2", sdf.parse("01/12/2021 11:32"), "corpo da noticia 2 - java", nuc1);
		Noticia not3 = new Noticia(null, "Titulo da noticia 3", sdf.parse("01/12/2021 12:32"), "corpo da noticia 3 - PHP", nuc2);
		
		nuc1.getNoticias().addAll(Arrays.asList(not1,not2));
		nuc2.getNoticias().addAll(Arrays.asList(not3));
		
		nucleoRepository.saveAll(Arrays.asList(nuc1,nuc2,nuc3));
		noticiaRepository.saveAll(Arrays.asList(not1,not2,not3));
		
	}

}
