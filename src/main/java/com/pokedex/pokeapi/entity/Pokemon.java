package com.pokedex.pokeapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokemon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private String nome;
	
	private String tipo;
	
	private String fraqueza;
	
	private boolean isLendario;
	
	
	public Pokemon() {
		super();
	}
	
	public Pokemon(int id, String nome, String tipo, String fraqueza, boolean isLendario) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.fraqueza = fraqueza;
		this.isLendario = isLendario;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getFraqueza() {
		return fraqueza;
	}
	public void setFraqueza(String fraqueza) {
		this.fraqueza = fraqueza;
	}
	public boolean isLendario() {
		return isLendario;
	}
	public void setLendario(boolean isLendario) {
		this.isLendario = isLendario;
	}
	
	
}
