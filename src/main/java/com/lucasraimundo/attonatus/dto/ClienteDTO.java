package com.lucasraimundo.attonatus.dto;

import com.lucasraimundo.attonatus.domain.Cliente;

import jakarta.validation.constraints.NotEmpty;

public class ClienteDTO {

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String nasc;
	
	public ClienteDTO(){
		
	}

	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.nasc = obj.getNasc();
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

	public String getNasc() {
		return nasc;
	}

	public void setNasc(String nasc) {
		this.nasc = nasc;
	}
	
	
	
	
}
