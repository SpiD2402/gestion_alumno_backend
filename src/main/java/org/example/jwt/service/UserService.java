package org.example.jwt.service;


import org.example.jwt.entity.Usuario;

import java.util.Map;
import java.util.Optional;

public interface UserService {
    Usuario save(Map<String ,String> user);
    Map<String, String> login(Map<String,String> login);
    Optional<Usuario> findById(Long id);
    Usuario update(Usuario usuario);
    void delete(Long id);
}
