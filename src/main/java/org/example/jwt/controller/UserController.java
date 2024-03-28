package org.example.jwt.controller;

import org.example.jwt.entity.Usuario;
import org.example.jwt.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/singup")
    public Usuario save(@RequestBody (required = true)Map<String,String> requestMap) {
        return userService.save(requestMap);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody(required = true) Map<String,String> requestMap) {


            return userService.login(requestMap);

    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario) {
        return userService.update(usuario);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
