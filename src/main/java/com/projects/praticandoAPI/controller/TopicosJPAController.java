package com.projects.praticandoAPI.controller;

import java.net.URI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.projects.praticandoAPI.controller.dto.TopicoDto;
import com.projects.praticandoAPI.controller.form.TopicoForm;

import com.projects.praticandoAPI.modelo.Topico;
import com.projects.praticandoAPI.repository.ProfessorRepository;
import com.projects.praticandoAPI.repository.TopicoRepository;

@RestController

@RequestMapping("/topicos")
public class TopicosJPAController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@GetMapping
	public List<TopicoDto> lista(String nomeProfessor) {
		if (nomeProfessor == null) {
			List<Topico> topicos = topicoRepository.findAll();
			return TopicoDto.converter(topicos);
		} else {
			List<Topico> topicos = topicoRepository.findByProfessor(nomeProfessor);
			return TopicoDto.converter(topicos);
		}
	}
	
	@PostMapping
	public ResponseEntity<TopicoDto> cadastrar(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter(professorRepository);
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
	}

}
