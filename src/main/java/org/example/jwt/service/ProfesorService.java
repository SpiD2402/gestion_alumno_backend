package org.example.jwt.service;

import org.example.jwt.entity.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {

    List<Profesor> allProfesor();

    Profesor addProfeor(Profesor profesor);

    Optional<Profesor>getByiD(Long id);

    Profesor deleteProfesor(Long id);

    Profesor upateProfesor(Profesor profesor,Long id);



}
