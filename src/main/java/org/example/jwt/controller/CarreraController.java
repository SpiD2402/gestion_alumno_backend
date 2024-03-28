package org.example.jwt.controller;

import org.example.jwt.entity.Carrera;
import org.example.jwt.service.CarreraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carreraa")
public class CarreraController {

    private final CarreraService carreraService;


    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    @GetMapping
    public ResponseEntity<?>allCarrera()
    {

        return new ResponseEntity<>(carreraService.allCarrera(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<?>addCarrera(@RequestBody Carrera carrera)
    {
        return  new ResponseEntity<>(carreraService.addCarrera(carrera),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteCarrera(@PathVariable Long id)
    {
        return  new ResponseEntity<>(carreraService.deleteCarrera(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>updateCarrera(@RequestBody Carrera carrera,@PathVariable Long id)
    {
        return  new ResponseEntity<>(carreraService.updateCarrera(id,carrera),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>getById(@PathVariable Long id)
    {
        return  new ResponseEntity<>(carreraService.getById(id),HttpStatus.OK);
    }

}
