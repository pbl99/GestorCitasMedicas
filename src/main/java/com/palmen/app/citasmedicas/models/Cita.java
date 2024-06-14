package com.palmen.app.citasmedicas.models;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "citas")
public class Cita {

	private Usuario usuario;
	private LocalDate fecha;
	private String medico;
	private String descripcion;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}