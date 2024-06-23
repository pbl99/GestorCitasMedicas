package com.palmen.app.citasmedicas.services;

import com.palmen.app.citasmedicas.models.Usuario;

public interface IUsuarioService {
	void crearUsuario(Usuario usuario);
	Usuario findByDniAndNombre(String dni, String nombre);

}
