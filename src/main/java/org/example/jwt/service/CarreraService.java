package org.example.jwt.service;

import org.example.jwt.entity.Carrera;

import java.util.List;
import java.util.Optional;

public interface CarreraService {

    List<Carrera> allCarrera();

    Optional<Carrera> getById(Long id);

    Carrera addCarrera (Carrera carrera);

    Carrera deleteCarrera(Long id);

    Optional<Carrera> updateCarrera(Long id,Carrera carrera);


}
