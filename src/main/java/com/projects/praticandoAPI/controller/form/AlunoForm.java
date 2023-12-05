package com.projects.praticandoAPI.controller.form;

import com.projects.praticandoAPI.modelo.Professor;
import com.projects.praticandoAPI.modelo.Topico;
import com.projects.praticandoAPI.modelo.Aluno;
import com.projects.praticandoAPI.repository.ProfessorRepository;
import com.projects.praticandoAPI.repository.AlunoRepository;

public class AlunoForm {
	
	private String nome;
	private String email;
	private String ra;
	
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
	
	public Aluno converter(AlunoRepository alunoRepository) {
		
		return new Aluno(nome, email, ra);
	}
}
