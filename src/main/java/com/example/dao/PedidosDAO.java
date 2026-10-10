package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import com.example.config.ConexionBD;
import com.model.Pedidos;

public class PedidosDAO {

    public void guardar(Pedidos pedido) {
        String sql = "INSERT INTO pedidos (cliente_id, fecha_pedido, total, estado) "
                   + "VALUES (?, ?, ?, ?) RETURNING id";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, pedido.getClienteId());
            stmt.setTimestamp(2, Timestamp.valueOf(pedido.getFechaPedido() != null ? pedido.getFechaPedido() : LocalDateTime.now()));
            stmt.setBigDecimal(3, pedido.getTotal());
            stmt.setString(4, pedido.getEstado() != null ? pedido.getEstado() : "pendiente");

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                pedido.setId(rs.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}