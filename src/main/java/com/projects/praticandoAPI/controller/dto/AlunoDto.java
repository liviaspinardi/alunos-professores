package com.projects.praticandoAPI.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.projects.praticandoAPI.modelo.Aluno;

public class AlunoDto {
	
	private Long id;
	private String nome;
	private String email;
	private String ra;
	
	
	public AlunoDto(Aluno aluno) {
		super();
		this.id = aluno.getId();
		this.nome = aluno.getNome();
		this.email = aluno.getEmail();
		this.ra = aluno.getRA();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getRA() {
		return ra;
	}
	
	public static List<AlunoDto> converter(List<Aluno> alunos) {
		return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
	}
	
}
