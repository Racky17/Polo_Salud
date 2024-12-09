package com.polo.polo_de_salud.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class carrerasModelo<usuarios> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private Long idCarrera;

    @ManyToOne
    @JoinColumn(name = "id_persona", foreignKey = @ForeignKey(name = "carreras_ibfk_1"))
    private usuarios usuario; // Suponiendo que hay una clase Persona que representa la tabla persona

    @Column(name = "nombre_carrera", nullable = false, length = 50)
    private String nombreCarrera;

    @Column(name = "rut", nullable = false)
    private Integer rut;

    @Column(name = "nombre_Miembro", nullable = false, length = 50)
    private String nombreMiembro;

    @Column(name = "apellido_Miembro", nullable = false, length = 50)
    private String apellidoMiembro;

    @Column(name = "email_miembro", nullable = false, length = 150)
    private String emailMiembro;

    @Column(name = "fono_Miembro", nullable = false)
    private Integer fonoMiembro;

    // Getters and Setters

    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long id) {
        this.idCarrera = id;
    }

    public usuarios getusuario() {
        return usuario;
    }

    public void setusuario(usuarios usuario) {
        this.usuario = usuario;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public String getNombreMiembro() {
        return nombreMiembro;
    }

    public void setNombreMiembro(String nombreMiembro) {
        this.nombreMiembro = nombreMiembro;
    }

    public String getApellidoMiembro() {
        return apellidoMiembro;
    }

    public void setApellidoMiembro(String apellidoMiembro) {
        this.apellidoMiembro = apellidoMiembro;
    }

    public String getEmailMiembro() {
        return emailMiembro;
    }

    public void setEmailMiembro(String emailMiembro) {
        this.emailMiembro = emailMiembro;
    }

    public Integer getFonoMiembro() {
        return fonoMiembro;
    }

    public void setFonoMiembro(Integer fonoMiembro) {
        this.fonoMiembro = fonoMiembro;
    }
}