package com.palmen.app.citasmedicas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.palmen.app.citasmedicas.models.Cita;
import com.palmen.app.citasmedicas.models.Usuario;
import com.palmen.app.citasmedicas.repositories.UsuarioRepository;

@Service
public class CitaServiceImpl implements ICitaService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void crearCita(String especialidad, String medico, String fecha, String descripcion, String usuarioId) {
		Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
		if (usuarioOpt.isPresent()) {
			Usuario usuario = usuarioOpt.get();

			Cita nuevaCita = new Cita();
			nuevaCita.setEspecialidad(especialidad);
			nuevaCita.setMedico(medico);
			nuevaCita.setFecha(fecha);
			nuevaCita.setDescripcion(descripcion);

			usuario.addCita(nuevaCita);

			usuarioRepository.save(usuario); // Guardar el usuario con la nueva cita embebida
		} else {
			throw new RuntimeException("Usuario no encontrado");
		}
	}

	@Override
	public List<Cita> buscarCitas(String usuarioId) {
		Usuario usuario = usuarioRepository.findByDni(usuarioId);
		return usuario.getCitas();
	}

}