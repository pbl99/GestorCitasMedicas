package com.palmen.app.citasmedicas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CitaController {

	@GetMapping("/pedir-cita")
	public String pedirCita() {
		return "pedir-cita";
	}
}
