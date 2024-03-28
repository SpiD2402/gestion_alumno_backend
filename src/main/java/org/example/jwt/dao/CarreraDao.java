package org.example.jwt.dao;

import org.example.jwt.entity.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarreraDao extends JpaRepository<Carrera,Long> {
}
