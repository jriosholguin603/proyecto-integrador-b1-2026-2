package com.model;

import java.time.LocalDateTime;

public class Clientes {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
    private String estado;
    private LocalDateTime fechaRegistro;


    public Clientes(Long id, String nombre, String apellido, String email, String telefono,
            String direccion, String estado, LocalDateTime fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;
    }


    public Clientes(String nombre, String apellido, String email, String telefono,
            String direccion, String estado, LocalDateTime fechaRegistro) {
        this(null, nombre, apellido, email, telefono, direccion, estado, fechaRegistro);
    }


    public Clientes() {
        this.fechaRegistro = LocalDateTime.now();
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }

    @Override
    public String toString() {
        return "Clientes [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
    }
}


