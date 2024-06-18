package com.palmen.app.citasmedicas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palmen.app.citasmedicas.models.Cita;
import com.palmen.app.citasmedicas.repositories.CitaRepository;

@Service
public class CitaService {

	@Autowired
	private CitaRepository citaRepository;

	public void crearCita(Cita cita) {

		citaRepository.save(cita);
	}
	
	

}
