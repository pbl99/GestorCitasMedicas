package com.palmen.app.citasmedicas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palmen.app.citasmedicas.models.Usuario;
import com.palmen.app.citasmedicas.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void crearUsuario(Usuario usuario) {
		if (usuarioRepository.findByDni(usuario.getDni()) != null) {
			throw new IllegalArgumentException("El usuario ya está registrado.");
		}
		usuarioRepository.save(usuario);
	}

	public Usuario findByDniAndNombre(String dni, String nombre) {
		return usuarioRepository.findByDniNombre(dni, nombre);
	}

}
