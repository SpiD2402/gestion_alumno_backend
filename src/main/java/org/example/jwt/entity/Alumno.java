package org.example.jwt.entity;

import javax.persistence.*;

@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_alumno;

    private String nombre;

    private String ap_paterno;

    private String ap_materno;

    private int status=1;

    public Long getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Long id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp_paterno() {
        return ap_paterno;
    }

    public void setAp_paterno(String ap_paterno) {
        this.ap_paterno = ap_paterno;
    }

    public String getAp_materno() {
        return ap_materno;
    }

    public void setAp_materno(String ap_materno) {
        this.ap_materno = ap_materno;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
