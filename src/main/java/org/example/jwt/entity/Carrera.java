package org.example.jwt.entity;

import javax.persistence.*;

@Entity
@Table
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_carrera;
    private String nombre;

    private double duracion;

    private String image_carera;

    private int status =1;

    public Long getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(Long id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getImage_carera() {
        return image_carera;
    }

    public void setImage_carera(String image_carera) {
        this.image_carera = image_carera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
