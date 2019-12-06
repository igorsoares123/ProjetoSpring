package com.cadtimes.app.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
@Entity
public class Time implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long codigo;
	@NotBlank
	private String tecnico;
	@NotBlank
	private String nome;
	
	public long getCodigo() {
		return codigo;
	}  
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}
	public String getTecnico() {
		return tecnico;
	}
	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
