package br.edu.ifms.pesquisa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
public class Membro implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String pathFoto;
	private String pathLattes;
	private String email;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="funcao_id")	
	private Funcao funcao;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "membros")
	private List<Nucleo> nucleos = new ArrayList<Nucleo>();
	
	public Membro() {
		// TODO Auto-generated constructor stub
	}

	public Membro(Integer id, String nome, String pathFoto, String pathLattes, String email, Funcao funcao) {
		super();
		this.id = id;
		this.nome = nome;
		this.pathFoto = pathFoto;
		this.pathLattes = pathLattes;
		this.email = email;
		this.funcao = funcao;
	}

	
	public List<Nucleo> getNucleos() {
		return nucleos;
	}

	public void setNucleos(List<Nucleo> nucleos) {
		this.nucleos = nucleos;
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

	public String getPathFoto() {
		return pathFoto;
	}

	public void setPathFoto(String pathFoto) {
		this.pathFoto = pathFoto;
	}

	public String getPathLattes() {
		return pathLattes;
	}

	public void setPathLattes(String pathLattes) {
		this.pathLattes = pathLattes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
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
		Membro other = (Membro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	

}
