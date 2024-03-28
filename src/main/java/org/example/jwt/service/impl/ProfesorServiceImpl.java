package org.example.jwt.service.impl;

import org.example.jwt.dao.ProfesorDao;
import org.example.jwt.entity.Alumno;
import org.example.jwt.entity.Profesor;
import org.example.jwt.service.ProfesorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorDao profesorDao;

    public ProfesorServiceImpl(ProfesorDao profesorDao) {
        this.profesorDao = profesorDao;
    }

    @Override
    public List<Profesor> allProfesor() {
        return profesorDao.findAll();
    }

    @Override
    public Profesor addProfeor(Profesor profesor) {
        return profesorDao.save(profesor);
    }

    @Override
    public Optional<Profesor> getByiD(Long id) {

        Optional<Profesor> exist = profesorDao.findById(id);
        if (exist.isPresent())
        {
            return  exist;
        }
        return Optional.empty();
    }

    @Override
    public Profesor deleteProfesor(Long id) {
        Optional<Profesor> exist = profesorDao.findById(id);
        if (exist.isPresent())
        {
           Profesor profesor = exist.get();
            profesorDao.deleteById(id);
            return profesor;
        }
        return null;
    }

    @Override
    public Profesor upateProfesor(Profesor profesor, Long id) {
        Optional<Profesor> exist = profesorDao.findById(id);
        if (exist.isPresent())
        {
            Profesor profesorExist = exist.get();
            profesorExist.setNombre(profesor.getNombre());
            profesorExist.setAp_paterno(profesor.getAp_paterno());
            profesorExist.setAp_materno(profesor.getAp_materno());
            profesorDao.save(profesorExist);
            return profesorExist;
        }
        return null;
    }
}
