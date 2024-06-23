package com.palmen.app.citasmedicas.services;

import java.util.List;

public interface IDatosCitaService {
	List<String> getFechasDisponibles();

	List<String> getMedicosDisponibles();

	List<String> getEspecialidadesDisponibles();

}
