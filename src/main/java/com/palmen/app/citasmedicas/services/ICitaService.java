package com.palmen.app.citasmedicas.services;

import java.util.List;

import com.palmen.app.citasmedicas.models.Cita;

public interface ICitaService {
	void crearCita(String especialidad, String medico, String fecha, String descripcion, String usuarioId);
	List<Cita> buscarCitas(String usuarioId);
}
