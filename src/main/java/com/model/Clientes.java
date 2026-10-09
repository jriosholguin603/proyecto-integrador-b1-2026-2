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

    // Constructor completo
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

}