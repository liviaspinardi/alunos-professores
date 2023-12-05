package com.projects.praticandoAPI.controller.form;

import com.projects.praticandoAPI.modelo.Professor;
import com.projects.praticandoAPI.modelo.Topico;
import com.projects.praticandoAPI.repository.ProfessorRepository;

public class TopicoForm {

	private String titulo;
	private String mensagem;
	private String nomeProfessor;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public Topico converter(ProfessorRepository professorRepository) {
		Professor professor = professorRepository.findByProfessor(nomeProfessor);
		return new Topico(titulo, mensagem, professor);
	}

}
