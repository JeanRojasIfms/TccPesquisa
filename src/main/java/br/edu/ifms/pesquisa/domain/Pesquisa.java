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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pesquisa implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
		
	@ManyToMany
	@JoinTable(
			name="PESQUISA_DISCENTE",
			joinColumns = @JoinColumn(name="pesquisa_id"),
			inverseJoinColumns = @JoinColumn(name="discente_id"))
	private List<Discente> discentes = new ArrayList<Discente>();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="nucleo_id")
	private Nucleo nucleo;
	
	public Pesquisa() {
		// TODO Auto-generated constructor stub
	}

	public Pesquisa(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	public Pesquisa(Integer id, String descricao, Nucleo nucleo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.nucleo = nucleo;
	}

	public Nucleo getNucleo() {
		return nucleo;
	}

	public void setNucleo(Nucleo nucleo) {
		this.nucleo = nucleo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Discente> getDiscentes() {
		return discentes;
	}

	public void setDiscentes(List<Discente> discentes) {
		this.discentes = discentes;
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
		Pesquisa other = (Pesquisa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	

}
