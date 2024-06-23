package com.palmen.app.citasmedicas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.palmen.app.citasmedicas.models.Cita;
import com.palmen.app.citasmedicas.models.Usuario;
import com.palmen.app.citasmedicas.services.ICitaService;
import com.palmen.app.citasmedicas.services.IDatosCitaService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CitaController {

	@Autowired
	private ICitaService citaService;

	@Autowired
	private IDatosCitaService datosCitaService;

	/**
	 * Muestra la página para pedir una cita.
	 */
	@GetMapping("/mostrarPedirCita")
	public String pedirCita(HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario != null) {
			model.addAttribute("usuario", usuario);
			model.addAttribute("fechasDisponibles", datosCitaService.getFechasDisponibles());
			model.addAttribute("medicosDisponibles", datosCitaService.getMedicosDisponibles());
			model.addAttribute("especialidadesDisponibles", datosCitaService.getEspecialidadesDisponibles());
			model.addAttribute("cita", new Cita());

			return "pedir-cita";
		} else {
			return "redirect:/login-usuario";
		}
	}

	/**
	 * Procesa la solicitud para crear una nueva cita.
	 */
	@PostMapping("/procesarPedirCita")
	public String crearCita(@RequestParam("especialidad") String especialidad, @RequestParam("medico") String medico,
			@RequestParam("fecha") String fecha, @RequestParam("descripcion") String descripcion, HttpSession session,
			Model model) {

		Usuario usuario = (Usuario) session.getAttribute("usuario");
		citaService.crearCita(especialidad, medico, fecha, descripcion, usuario.getDni());

		model.addAttribute("cita", new Cita());
		return "redirect:/historialCitas";
	}

	/**
	 * Muestra el historial de citas del usuario.
	 */
	@GetMapping("/historialCitas")
	public String mostrarHistorialCitas(HttpSession session, Model model) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario != null) {
			List<Cita> citas = citaService.buscarCitas(usuario.getDni());

			model.addAttribute("citas", citas);
			model.addAttribute("usuario", usuario);

			return "ver-citas";
		} else {
			return "redirect:/login-usuario";
		}
	}
}
