package com.palmen.app.citasmedicas.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.palmen.app.citasmedicas.models.Cita;

@Repository
public interface CitaRepository extends MongoRepository<Cita, String>{

}
