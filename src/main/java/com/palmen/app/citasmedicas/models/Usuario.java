package com.palmen.app.citasmedicas.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Document(collection = "usuarios")
public class Usuario {

	@Id
	@Size(min = 9, max = 9, message = "El Dni debe tener 9 dígitos")
	private String dni;

	@NotBlank
	private String nombre;

	@NotBlank
	private String apellidos;

	@NotNull
	@Min(value = 18, message = "La edad debe ser mayor o igual a 18")
	private Integer edad;

	private List<Cita> citas = new ArrayList<>();

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public void addCita(Cita cita) {
		this.citas.add(cita);
	}

}
