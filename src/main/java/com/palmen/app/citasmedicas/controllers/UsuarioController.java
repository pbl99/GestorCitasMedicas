package com.palmen.app.citasmedicas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.palmen.app.citasmedicas.models.Usuario;
import com.palmen.app.citasmedicas.models.UsuarioLoginDTO;
import com.palmen.app.citasmedicas.services.IUsuarioService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	/**
	 * Muestra la página de inicio con el formulario de registro de usuario.
	 */
	@GetMapping("/")
	public String obtenerCita(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "index";
	}

	/**
	 * Procesa el registro de un nuevo usuario.
	 */
	@PostMapping("/registrarUsuario")
	public String crearUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "index";
		}

		try {
			usuarioService.crearUsuario(usuario);
		} catch (IllegalArgumentException e) {
			result.addError(new FieldError("usuario", "dni", "El dni ya está registrado"));
			return "index";
		}
		return "redirect:/mostrarPedirCita";
	}

	/**
	 * Muestra la página de login de usuario.
	 */
	@GetMapping("/login-usuario")
	public String loginUsuario(Model model) {
		model.addAttribute("usuarioLogin", new UsuarioLoginDTO());
		return "login";
	}

	/**
	 * Valida las credenciales del usuario.
	 */
	@PostMapping("/validarUsuario")
	public String validarUsuario(@Valid @ModelAttribute("usuarioLogin") UsuarioLoginDTO usuarioLoginDTO,
			BindingResult result, HttpSession session, Model model) {

		if (result.hasErrors()) {
			return "login";
		}
		// Verifica que tanto el DNI como el nombre estén presentes
		Usuario usuario = usuarioService.findByDniAndNombre(usuarioLoginDTO.getDni(), usuarioLoginDTO.getNombre());

		// Si se encuentra el usuario, se guarda en la sesión y redirige a la página de
		// pedir cita
		if (usuario != null) {
			session.setAttribute("usuario", usuario);
			return "redirect:/mostrarPedirCita";
		}
		model.addAttribute("error", "El dni y el nombre no corresponden con un usuario registrado");
		return "login";
	}
}
