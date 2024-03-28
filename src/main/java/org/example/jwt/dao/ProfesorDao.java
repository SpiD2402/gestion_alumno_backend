package org.example.jwt.dao;

import org.example.jwt.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorDao  extends JpaRepository<Profesor,Long> {
}
