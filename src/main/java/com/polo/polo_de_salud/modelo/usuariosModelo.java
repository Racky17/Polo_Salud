package com.polo.polo_de_salud.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios") // Nombre de la tabla en la base de datos
public class usuariosModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Integer idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false, foreignKey = @ForeignKey(name = "usuarios_ibfk_1")) // Relación con la tabla de roles
    private rolModelo rol;

    @Column(name = "nombre", nullable = false, length = 50)
    private String name;

    @Column(name = "email", nullable = false, length = 64, unique = true)
    private String email;

    @Column(name = "fono", nullable = false)
    private Integer fono;

    @Column(name = "rut", nullable = false) // RUT
    private Integer rut;

    // Getters y Setters

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public rolModelo getRol() {
        return rol;
    }

    public void setRol(rolModelo rol) {
        this.rol = rol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFono() {
        return fono;
    }

    public void setFono(Integer fono) {
        this.fono = fono;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }
}