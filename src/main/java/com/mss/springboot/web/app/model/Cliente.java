package com.mss.springboot.web.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;


@Document("Cliente")
public class Cliente {
	
	@Id
	private Integer id;
	@NotBlank(message = "El nombre no puede estar vacío")
	private String nombre;
	@NotBlank(message = "La ciudad no puede estar vacía")
	private String ciudad;
	@NotBlank(message = "El correo no puede estar vacío")
	private String email;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}