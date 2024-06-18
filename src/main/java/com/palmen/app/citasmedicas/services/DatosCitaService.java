package com.palmen.app.citasmedicas.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DatosCitaService {
	public List<String> getFechasDisponibles() {
		return Arrays.asList("2024-06-15", "2024-06-16", "2024-06-17"); // Ejemplo de fechas disponibles
	}

	public List<String> getMedicosDisponibles() {
		return Arrays.asList("Dr. García", "Dr. Pérez", "Dra. López"); // Ejemplo de médicos disponibles
	}

	public List<String> getEspecialidadesDisponibles() {
		return Arrays.asList("Cardiología", "Dermatología", "Pediatría"); // Ejemplo de especialidades disponibles
	}
}
