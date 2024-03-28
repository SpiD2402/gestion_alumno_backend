package org.example.jwt.service.impl;

import org.example.jwt.dao.CarreraDao;
import org.example.jwt.entity.Carrera;
import org.example.jwt.service.CarreraService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraServiceImpl implements CarreraService {

    private final CarreraDao carreraDao;

    public CarreraServiceImpl(CarreraDao carreraDao) {
        this.carreraDao = carreraDao;
    }

    @Override
    public List<Carrera> allCarrera() {
        return carreraDao.findAll();
    }

    @Override
    public Optional<Carrera> getById(Long id) {
        return carreraDao.findById(id);
    }

    @Override
    public Carrera addCarrera(Carrera carrera) {
        return carreraDao.save(carrera);
    }

    @Override
    public Carrera deleteCarrera(Long id) {
        Optional<Carrera> carreraExist = carreraDao.findById(id);
          if(carreraExist.isPresent())
          {
              Carrera carrera = carreraExist.get();
              carreraDao.deleteById(id);
              return  carrera;
          }
        return null;
    }

    @Override
    public Optional<Carrera> updateCarrera(Long id, Carrera carrera) {
        Optional<Carrera> carreraExist = carreraDao.findById(id);
        if (carreraExist.isPresent()) {
            Carrera carr = carreraExist.get();
            carr.setDuracion(carrera.getDuracion());
            carr.setNombre(carrera.getNombre());
            carreraDao.save(carr);
            return Optional.of(carr);
        }
        return Optional.empty();
    }
}
