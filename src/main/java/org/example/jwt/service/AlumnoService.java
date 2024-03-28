package org.example.jwt.service;

import org.example.jwt.entity.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {

    List<Alumno> allAlumno();

    Alumno addAlumno(Alumno alumno);

    Alumno deleteAlumno(Long id);

    Optional<Alumno> actualizarAlumno(Long id, Alumno alumno);

    Optional<Alumno> getById(Long id);



}
