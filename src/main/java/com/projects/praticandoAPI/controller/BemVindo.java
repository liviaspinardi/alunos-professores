package com.projects.praticandoAPI.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BemVindo {
	@RequestMapping("/facens")
	@ResponseBody
	public String bemVindo() {
		return "Bem vindo(a) a Facens!";
	}
}
