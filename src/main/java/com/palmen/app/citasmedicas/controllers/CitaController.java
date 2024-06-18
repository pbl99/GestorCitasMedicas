package com.palmen.app.citasmedicas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.palmen.app.citasmedicas.models.Cita;
import com.palmen.app.citasmedicas.services.CitaService;
import com.palmen.app.citasmedicas.services.DatosCitaService;

@Controller
public class CitaController {

	@Autowired
	private CitaService citaService;

	@Autowired
	private DatosCitaService datosCitaService;

	@GetMapping("/pedir-cita")
	public String pedirCita(Model model) {
		model.addAttribute("fechasDisponibles", datosCitaService.getFechasDisponibles());
		model.addAttribute("medicosDisponibles", datosCitaService.getMedicosDisponibles());
		model.addAttribute("fechasDisponibles", datosCitaService.getEspecialidadesDisponibles());
		model.addAttribute("cita", new Cita());

		return "pedir-cita";
	}
	
	@PostMapping("/crear-cita")
	public String crearCita() {
		return "index";
	}
}
