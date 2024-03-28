package org.example.jwt.security;

import org.example.jwt.dao.UserDao;
import org.example.jwt.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CustomerDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    private Usuario usuario;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        usuario  =  userDao.findByUsername(username);
        if(usuario!=null)
        {
            return new User(usuario.getUsername(),usuario.getPassword(), new ArrayList<>());
        }

        else
        {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

    }

    public Usuario getUsuario()
    {
        return usuario;
    }

}
