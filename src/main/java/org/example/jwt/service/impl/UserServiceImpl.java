package org.example.jwt.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.jwt.dao.UserDao;
import org.example.jwt.entity.Usuario;
import org.example.jwt.security.CustomerDetailService;
import org.example.jwt.security.jwt.JwtUtil;
import org.example.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomerDetailService customerDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Usuario save(Map<String ,String> user) {

        Usuario usuario = getUsuariosMap(user);
        String constraCodif= passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(constraCodif);
        return userDao.save(usuario);
    }

    @Override
    public Map<String, String> login(Map<String,String> login) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(login.get("username"), login.get("password")));
            if (authentication.isAuthenticated()) {
                String token = jwtUtil.generarToken(customerDetailService.getUsuario().getUsername(), customerDetailService.getUsuario().getRole());

                // Crea un objeto Map que contenga el token
                Map<String, String> response = new HashMap<>();
                response.put("token", token);

                return response;
            } else {
                // Devuelve un mensaje de error en caso de falla en la autenticación
                Map<String, String> errorResponse = new HashMap<>();
                errorResponse.put("error", "Usuario no registrado");
                return errorResponse;
            }
        } catch (Exception e) {
            // Maneja cualquier excepción que pueda ocurrir durante el proceso de autenticación
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Usuario no registrado");
            return errorResponse;
        }
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return userDao.save(usuario);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }



 public  Usuario getUsuariosMap(Map<String,String> requestMap)
 {
     Usuario usuario = new Usuario();
     usuario.setPassword(requestMap.get("password"));
     usuario.setRole("User");
     usuario.setUsername(requestMap.get("username"));
    return  usuario;
 }




}
