package org.example.jwt.controller;

import org.example.jwt.entity.Profesor;
import org.example.jwt.service.ProfesorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {

    private final ProfesorService profesorService;

    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }


    @GetMapping
    public ResponseEntity<?> allProfesor()
    {
        return new ResponseEntity<>(profesorService.allProfesor(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id)
    {
        return new ResponseEntity<>(profesorService.getByiD(id), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProfesor(@PathVariable Long id)
    {
        return new ResponseEntity<>(profesorService.deleteProfesor(id), HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateProfesor(@RequestBody Profesor profesor, @PathVariable Long id)
    {
        return new ResponseEntity<>(profesorService.upateProfesor(profesor,id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> adProfesor(@RequestBody Profesor profesor)
    {
        return new ResponseEntity<>(profesorService.addProfeor(profesor), HttpStatus.CREATED);
    }




}
