package com.pokedex.pokeapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pokedex.pokeapi.entity.Pokemon;

@Controller
public class BasicController {
	
	@RequestMapping("/home")
	public String index() {			
		System.out.println("Entrou aqui");
		return "/index";
	}
	
	
}
