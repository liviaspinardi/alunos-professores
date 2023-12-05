package com.projects.praticandoAPI.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.projects.praticandoAPI.controller.form.AlunoForm;

@Entity
public class Aluno {
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String ra;
	
	public Aluno() {
	}

	public Aluno(String nome, String email, String ra) {
		super();
		this.nome = nome;
		this.email = email;
		this.ra = ra;
	}
	
	public Aluno(AlunoForm dados) {
			
		this.setNome(nome);
		this.setEmail(email);
		this.setRA(ra);
		
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
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRA() {
		return ra;
	}

	public void setRA(String ra) {
		this.ra = ra;
	}

	

	

}
