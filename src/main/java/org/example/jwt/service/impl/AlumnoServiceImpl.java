package org.example.jwt.service.impl;


import org.example.jwt.dao.AlumnoDao;
import org.example.jwt.entity.Alumno;
import org.example.jwt.service.AlumnoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    private final AlumnoDao alumnoDao;

    public AlumnoServiceImpl(AlumnoDao alumnoDao) {
        this.alumnoDao = alumnoDao;
    }

    @Override
    public List<Alumno> allAlumno() {
        return alumnoDao.findAll();
    }

    @Override
    public Alumno addAlumno(Alumno alumno) {
        return alumnoDao.save(alumno);
    }

    @Override
    public Alumno deleteAlumno(Long id) {

        Optional<Alumno> alumnoEncontrado = alumnoDao.findById(id);
        if (alumnoEncontrado.isPresent())
        {
                Alumno alumnoEliminado  = alumnoEncontrado.get();
                alumnoDao.deleteById(id);
                return  alumnoEliminado;
        }
        return  null;

    }

    @Override
    public Optional<Alumno> actualizarAlumno(Long id, Alumno alumno) {

        Optional<Alumno> alumnoEcontrado = alumnoDao.findById(id);
        if (alumnoEcontrado.isPresent())
        {
            Alumno alumnoGet = alumnoEcontrado.get();
            alumnoGet.setAp_materno(alumno.getAp_materno());
            alumnoGet.setAp_paterno(alumno.getAp_paterno());
            alumnoGet.setNombre(alumno.getNombre());
            return Optional.of(alumnoDao.save(alumnoGet));
        }
        return Optional.empty() ;
    }

    @Override
    public Optional <Alumno> getById(Long id) {
        return  alumnoDao.findById(id);
    }
}
