package com.palmen.app.citasmedicas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.palmen.app.citasmedicas.models.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}