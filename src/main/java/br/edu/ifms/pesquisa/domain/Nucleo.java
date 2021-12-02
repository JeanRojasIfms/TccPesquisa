package br.edu.ifms.pesquisa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Nucleo implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String pathBanner;
	private String descricao;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="campus_id")
	private Campus campus;
	
	@OneToMany(mappedBy = "nucleo")
	private List<Noticia> noticias = new ArrayList<Noticia>();
	
	@OneToMany(mappedBy = "nucleo")
	private List<Pesquisa> pesquisas = new ArrayList<Pesquisa>();
	
	@ManyToMany
	@JoinTable(
			name="NUCLEO_MEMBRO",
			joinColumns = @JoinColumn(name="nucleo_id"),
			inverseJoinColumns = @JoinColumn(name="membro_id"))
	private List<Membro> membros = new ArrayList<Membro>();
	
	public Nucleo() {
		// TODO Auto-generated constructor stub
	}

	public Nucleo(Integer id, String nome, String pathBanner, String descricao, Campus campus) {
		super();
		this.id = id;
		this.nome = nome;
		this.pathBanner = pathBanner;
		this.descricao = descricao;
		this.campus = campus;
	}
	
	
	
	public List<Membro> getMembros() {
		return membros;
	}

	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}

	public List<Pesquisa> getPesquisas() {
		return pesquisas;
	}

	public void setPesquisas(List<Pesquisa> pesquisas) {
		this.pesquisas = pesquisas;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nucleo other = (Nucleo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
