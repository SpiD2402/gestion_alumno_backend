package org.example.jwt.controller;


import org.example.jwt.entity.Alumno;
import org.example.jwt.service.AlumnoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {

    private final AlumnoService alumnoService;


    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }


    @GetMapping
    public ResponseEntity<?> allAlumno()
    {
        return new ResponseEntity<>(alumnoService.allAlumno(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?>addAlumno(@RequestBody Alumno alumno)
    {
        return new ResponseEntity<>(alumnoService.addAlumno(alumno), HttpStatus.CREATED);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteAlumno(@PathVariable Long id)
    {
     return new   ResponseEntity<>(alumnoService.deleteAlumno(id),HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?>deleteAlumno(@RequestBody Alumno alumno, @PathVariable Long id)
    {
        return  new ResponseEntity<>(alumnoService.actualizarAlumno(id,alumno),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getById( @PathVariable Long id)
    {
        return  new ResponseEntity<>(alumnoService.getById(id),HttpStatus.OK);
    }

}