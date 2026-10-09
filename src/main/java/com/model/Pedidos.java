package com.example.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedidos {
    private Long id;
    private Long clienteId;
    private LocalDateTime fechaPedido;
    private BigDecimal total;
    private String estado;

    public Pedidos(Long id, Long clienteId, LocalDateTime fechaPedido, BigDecimal total, String estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.estado = estado;
    }

    public Pedidos(Long clienteId, LocalDateTime fechaPedido, BigDecimal total, String estado) {
        this(null, clienteId, fechaPedido, total, estado);
    }

    public Pedidos() {
        this.fechaPedido = LocalDateTime.now();
        this.estado = "pendiente";
    }
