package br.edu.ifms.pesquisa;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifms.pesquisa.domain.Campus;
import br.edu.ifms.pesquisa.domain.Discente;
import br.edu.ifms.pesquisa.domain.Funcao;
import br.edu.ifms.pesquisa.domain.Membro;
import br.edu.ifms.pesquisa.domain.Noticia;
import br.edu.ifms.pesquisa.domain.Nucleo;
import br.edu.ifms.pesquisa.domain.Pesquisa;
import br.edu.ifms.pesquisa.repository.CampusRepository;
import br.edu.ifms.pesquisa.repository.DiscenteRepository;
import br.edu.ifms.pesquisa.repository.FuncaoRepository;
import br.edu.ifms.pesquisa.repository.MembroRepository;
import br.edu.ifms.pesquisa.repository.NoticiaRepository;
import br.edu.ifms.pesquisa.repository.NucleoRepository;
import br.edu.ifms.pesquisa.repository.PesquisaRepository;

@SpringBootApplication
public class PesquisaApplication implements CommandLineRunner{
	@Autowired
	private CampusRepository campusRepository;
	@Autowired
	private NucleoRepository nucleoRepository;
	@Autowired
	private NoticiaRepository noticiaRepository;	
	@Autowired
	private MembroRepository membroRepository;	
	@Autowired
	private FuncaoRepository funcaoRepository;
	@Autowired
	private DiscenteRepository discenteRepository;
	@Autowired
	private PesquisaRepository pesquisaRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(PesquisaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Campus cam1 = new Campus(null, "IFMS","caminho do banner IFMS","caminho do logo do IFMS");
		Campus cam2 = new Campus(null, "UFMS","caminho banner UFMS","caminho do logo do UFMS");
		Campus cam3 = new Campus(null, "USP","caminho banner USP","caminho do logo do USP");
		Campus cam4 = new Campus(null, "Unicamp","caminho banner unicamp","caminho do logo do unicamp");
		Campus cam5 = new Campus(null, "UFPR","caminho banner Ufpr","caminho do logo do Ufpr");
		Campus cam6 = new Campus(null, "IFBA","caminho banner ifba","caminho do logo do ifba");
		Campus cam7 = new Campus(null, "IFPR","caminho banner ifpr","caminho do logo do ifpr");
		Campus cam8 = new Campus(null, "UFRGS","caminho banner ufrgs","caminho do logo do ufrgs");
		Campus cam9 = new Campus(null, "UFMG","caminho banner ufmg","caminho do logo do ufmg");
		Campus cam10 = new Campus(null, "Uniderp","caminho banner Uniderp","caminho do logo do Uniderp");
		
		
		
		Nucleo nuc1 = new Nucleo(null,"Nucleo Java", "banner do nucleo java", "pesquisas e tcc em java", cam1);
		Nucleo nuc2 = new Nucleo(null, "Nucleo PHP", "banner do nucleo PHP", "pesquisas e tcc em php", cam1);
		Nucleo nuc3 = new Nucleo(null, "Nucleo Pedagogico", "banner do nucleo pedagogico", "Pesquisas pedagogicas", cam2);
		
		cam1.getNucleos().addAll(Arrays.asList(nuc1,nuc2));
		cam2.getNucleos().addAll(Arrays.asList(nuc3));
		
		campusRepository.saveAll(Arrays.asList(cam1,cam2,cam3,cam4,cam5,cam6,cam7,cam8,cam9,cam10));		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Noticia not1 = new Noticia(null, "Titulo da noticia 1", sdf.parse("01/12/2021 10:32"), "corpo da noticia 1 - Java", nuc1);
		Noticia not2 = new Noticia(null, "Titulo da noticia 2", sdf.parse("01/12/2021 11:32"), "corpo da noticia 2 - java", nuc1);
		Noticia not3 = new Noticia(null, "Titulo da noticia 3", sdf.parse("01/12/2021 12:32"), "corpo da noticia 3 - PHP", nuc2);
		
		nuc1.getNoticias().addAll(Arrays.asList(not1,not2));
		nuc2.getNoticias().addAll(Arrays.asList(not3));
		
		//--------------------------
		Pesquisa pes1 = new Pesquisa(null, "Frameworks Java", nuc1);
		Pesquisa pes2 = new Pesquisa(null, "Java Server Faces", nuc1);
		Pesquisa pes3 = new Pesquisa(null, "Laravel Framework",nuc2);
		Pesquisa pes4 = new Pesquisa(null, "Cake Framework",nuc2);
		Pesquisa pes5 = new Pesquisa(null, "JPA",nuc1);
		Pesquisa pes6 = new Pesquisa(null, "Hibernate",nuc1);
		
		Discente d1 = new Discente(null, 1111, "Luan Pereira", "luan.pereira@ifms.edu.br","67 991294092");
		Discente d2 = new Discente(null, 2222, "Joana Dark", "joana.dark@ifms.edu.br","67 991294565");
		Discente d3 = new Discente(null, 3333, "Arthur Silva", "arthur.silva@ifms.edu.br","67 991293456");
		Discente d4 = new Discente(null, 4444, "Mariana Juliao", "mariana.juliao@ifms.edu.br","67 991292346");
		Discente d5 = new Discente(null, 5555, "Pedro Gustta", "pedro.gustta@ifms.edu.br","67 991299475");
		Discente d6 = new Discente(null, 6666, "Tobias Martinaci", "tobias.martinaci@ifms.edu.br","67 991290947");
		
		pes1.getDiscentes().addAll(Arrays.asList(d1,d2));
		pes2.getDiscentes().addAll(Arrays.asList(d1,d2,d3));
		pes3.getDiscentes().addAll(Arrays.asList(d4,d6));
		pes4.getDiscentes().addAll(Arrays.asList(d5,d6));
		pes5.getDiscentes().addAll(Arrays.asList(d6));
		pes6.getDiscentes().addAll(Arrays.asList(d1,d6));
		
		d1.getPesquisas().addAll(Arrays.asList(pes1,pes2,pes6));
		d2.getPesquisas().addAll(Arrays.asList(pes1,pes2));
		d3.getPesquisas().addAll(Arrays.asList(pes3));
		d4.getPesquisas().addAll(Arrays.asList(pes3));
		d5.getPesquisas().addAll(Arrays.asList(pes4));
		d6.getPesquisas().addAll(Arrays.asList(pes3,pes4,pes5,pes6));
		
		nuc1.getPesquisas().addAll(Arrays.asList(pes1,pes2,pes5,pes6));
		nuc2.getPesquisas().addAll(Arrays.asList(pes3,pes4));
		
		// ***************************************
		Funcao func1 = new Funcao(null, "Coordenador");
		Funcao func2 = new Funcao(null, "Pesquisador");
		Funcao func3 = new Funcao(null, "Estudante");
		
		Membro mem1 = new Membro(null, "Jean Rojas", "caminho da foto de jean", "caminho do lattes de jean", "jean.rojas@ifms.edu.br", func1);
		Membro mem2 = new Membro(null, "Rafael Françozo", "caminho da foto de Françozo", "caminho do lattes de Françozo", "rafael.francozo@ifms.edu.br", func1);
		Membro mem3 = new Membro(null, "Karine Tereza", "caminho da foto de Karine", "caminho do lattes de karine", "karineterezadepaula8@gmail.com", func3);
		Membro mem4 = new Membro(null, "Gabrielli Carmo vargas", "caminho da foto de Gabrielli", "caminho do lattes de gabrielli", "gabriellicarmovargasgabi@gmail.com", func3);
		Membro mem5 = new Membro(null, "Joao Motta", "caminho da foto de Joao", "caminho do lattes de Joao", "joaomotta@gmail.com", func2);
		Membro mem6 = new Membro(null, "Maria Silva", "caminho da foto de maria", "caminho do lattes de Maria", "mariasilva@gmail.com", func2);
		
		func1.getMembros().addAll(Arrays.asList(mem1,mem2));
		func2.getMembros().addAll(Arrays.asList(mem5,mem6));
		func3.getMembros().addAll(Arrays.asList(mem3,mem4));
		
		mem1.getNucleos().addAll(Arrays.asList(nuc1, nuc2));
		mem2.getNucleos().addAll(Arrays.asList(nuc2));
		mem3.getNucleos().addAll(Arrays.asList(nuc1));
		mem4.getNucleos().addAll(Arrays.asList(nuc1));
		mem5.getNucleos().addAll(Arrays.asList(nuc3));
		mem6.getNucleos().addAll(Arrays.asList(nuc3));
		
		nuc1.getMembros().addAll(Arrays.asList(mem1,mem3,mem4));
		nuc2.getMembros().addAll(Arrays.asList(mem1,mem2));
		nuc3.getMembros().addAll(Arrays.asList(mem5,mem6));
		
		funcaoRepository.saveAll(Arrays.asList(func1,func2,func3));
		membroRepository.saveAll(Arrays.asList(mem1,mem2,mem3,mem4,mem5,mem6));
		// ***************************************
		
		nucleoRepository.saveAll(Arrays.asList(nuc1,nuc2,nuc3));
		
		discenteRepository.saveAll(Arrays.asList(d1,d2,d3,d4,d5,d6));
		pesquisaRepository.saveAll(Arrays.asList(pes1,pes2,pes3,pes4,pes5,pes6));
		
		//--------------------------
		
		
		noticiaRepository.saveAll(Arrays.asList(not1,not2,not3));
		
				
		
		
	}

}
