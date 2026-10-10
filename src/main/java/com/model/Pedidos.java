package com.model;

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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public LocalDateTime getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDateTime fechaPedido) { this.fechaPedido = fechaPedido; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}

