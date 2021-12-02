package br.edu.ifms.pesquisa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Funcao implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String funcaoDoMembro;
	
	@JsonIgnore
	@OneToMany(mappedBy = "funcao")	
	private List<Membro> membros = new ArrayList<Membro>();
	
	public Funcao() {
		// TODO Auto-generated constructor stub
	}

	public Funcao(Integer id, String funcaoDoMembro) {
		super();
		this.id = id;
		this.funcaoDoMembro = funcaoDoMembro;		
	}

	
	public List<Membro> getMembros() {
		return membros;
	}

	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFuncaoDoMembro() {
		return funcaoDoMembro;
	}

	public void setFuncaoDoMembro(String funcaoDoMembro) {
		this.funcaoDoMembro = funcaoDoMembro;
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
		Funcao other = (Funcao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
