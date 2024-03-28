package org.example.jwt.entity;

import javax.persistence.*;

@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_profesor;

    private String nombre;
    private String ap_paterno;

    private String ap_materno;


    public Long getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Long id_profesor) {
        this.id_profesor = id_profesor;
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
}
