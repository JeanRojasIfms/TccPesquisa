package br.edu.ifms.pesquisa.dto;

import java.io.Serializable;

import br.edu.ifms.pesquisa.domain.Campus;

public class CampusDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private String pathBanner;
	private String pathLogo;
	
	public CampusDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CampusDTO(Campus obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.pathBanner = obj.getPathBanner();
		this.pathLogo = obj.getPathLogo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPathBanner() {
		return pathBanner;
	}

	public void setPathBanner(String pathBanner) {
		this.pathBanner = pathBanner;
	}

	public String getPathLogo() {
		return pathLogo;
	}

	public void setPathLogo(String pathLogo) {
		this.pathLogo = pathLogo;
	}
	
	

}
