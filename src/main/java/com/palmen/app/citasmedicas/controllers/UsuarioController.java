package com.palmen.app.citasmedicas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.palmen.app.citasmedicas.models.Usuario;
import com.palmen.app.citasmedicas.services.UsuarioService;

import jakarta.validation.Valid;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/")
	public String obtenerCita(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "index";
	}

	@PostMapping("/registrarUsuario")
	public String crearUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "index";
		}
		usuarioService.crearUsuario(usuario);
		return "pedir-cita";
	}

}