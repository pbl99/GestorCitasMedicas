package com.palmen.app.citasmedicas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.palmen.app.citasmedicas.models.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
	Usuario findByDni(String dni);
	@Query("{ 'dni' : ?0, 'nombre' : ?1 }")
	Usuario findByDniNombre(String dni, String nombre);
}