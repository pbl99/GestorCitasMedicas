package com.palmen.app.citasmedicas.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DatosCitaService implements IDatosCitaService {
	public List<String> getFechasDisponibles() {
		return Arrays.asList("15-06-2024 (8:30)", "15-06-2024 (8:45)", "15-06-2024 (9:00)", "15-06-2024 (9:15)",
				"15-06-2024 (9:30)", "15-06-2024 (9:45)", "15-06-2024 (10:00)", "15-06-2024 (10:15)",
				"15-06-2024 (10:30)", "15-06-2024 (10:45)", "15-06-2024 (11:00)");
	}

	public List<String> getMedicosDisponibles() {
		return Arrays.asList("Dr. García", "Dr. Pérez", "Dra. López", "Dra. Fernandez", "Dr. Ernesto", "Dr.Julián");
	}

	public List<String> getEspecialidadesDisponibles() {
		return Arrays.asList("Cardiología", "Dermatología", "Pediatría", "Urología", "Odontología", "Cirugía",
				"Medicina familiar");
	}
}
