package org.example.jwt.dao;

import org.example.jwt.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserDao extends JpaRepository<Usuario, Long> {


    Usuario findByUsername(String username);

}
