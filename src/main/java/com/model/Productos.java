package com.model;

import java.math.BigDecimal;

public class Productos {
    private Integer codigo;
    private String producto;
    private String descripcion;
    private BigDecimal precio;

    public Productos(Integer codigo, String producto, String descripcion, BigDecimal precio) {
        this.codigo = codigo;
        this.producto = producto;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Productos(String producto, String descripcion, BigDecimal precio) {
        this(null, producto, descripcion, precio);
    }

    public Productos() {
        this.precio = BigDecimal.ZERO;
    }

    public Integer getCodigo() { return codigo; }
    public void setCodigo(Integer codigo) { this.codigo = codigo; }

    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    @Override
    public String toString() {
        return "Producto [codigo=" + codigo + ", producto=" + producto + ", precio=" + precio + "]";
    }
}