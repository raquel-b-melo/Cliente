package com.raquel.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name="cliente")
@Entity

public class Cliente {

	
	public Cliente() {}

	
	
	public Cliente(Long id, String nome, LocalDate aniversario,
			@Pattern(regexp = "^\\([0-9]{2}\\) [0-9]?[0-9]{4}-[0-9]{4}$", message = "Formato esperado (11) 99999-9999") String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.aniversario = aniversario;
		this.telefone = telefone;
	}



	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Nome")
	private String nome;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@Column(name="Aniversario")
	private LocalDate aniversario;
	
	@Pattern(regexp = "^\\([0-9]{2}\\) [0-9]?[0-9]{4}-[0-9]{4}$", message="Formato esperado (11) 99999-9999")
	@Column(name="Telefone")
	private String telefone;

	

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

	public LocalDate getAniversario() {
		return aniversario;
	}

	public void setAniversario(LocalDate aniversario) {
		this.aniversario = aniversario;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
