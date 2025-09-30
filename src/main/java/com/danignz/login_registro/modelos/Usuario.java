package com.danignz.login_registro.modelos;

import java.time.LocalDate;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(min = 3, max = 15, message = "El nombre de usuario debe tener entre 3 y 15 caracteres")
    @Column(unique = true)
    private String nombreUsuario;

    
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
             message = "La contraseña debe incluir mayúscula, minúscula y número")
    private String contrasena;

    @Transient 
    @NotBlank(message = "Debe confirmar la contraseña")
    private String confirmacionContrasena;

    
    @Email(message = "Correo inválido")
    private String correo;

    
    @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "El nombre no puede contener números")
    private String nombre;

  
    @Size(min = 3, message = "El apellido debe tener al menos 3 caracteres")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ\\s]+$", message = "El apellido no puede contener números")
    private String apellido;
    private LocalDate fechaDeNacimiento;

    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaActualizacion;


    public Usuario() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getConfirmacionContrasena() {
        return confirmacionContrasena;
    }

    public void setConfirmacionContrasena(String confirmacionContrasena) {
        this.confirmacionContrasena = confirmacionContrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    

}
