package com.example.dao;

import com.example.config.ConexionBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetallePedidoDAO {

    public void guardar(DetallePedido detalle) {
        String sql = "INSERT INTO detalle_pedido (pedido_id, producto_id, cantidad, precio_unitario, subtotal) "
                   + "VALUES (?, ?, ?, ?, ?) RETURNING id";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, detalle.getPedidoId());
            stmt.setLong(2, detalle.getPedidoId());
            stmt.setInt(3, detalle.getCantidad());
            stmt.setBigDecimal(4, detalle.getPrecioUnitario());
            stmt.setBigDecimal(5, detalle.getSubtotal());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                detalle.setId(rs.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(DetallePedido detalle) {
        String sql = "UPDATE detalle_pedido SET pedido_id=?, producto_id=?, cantidad=?, precio_unitario=?, subtotal=? WHERE id=?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, detalle.getPedidoId());
            stmt.setLong(2, detalle.getPedidoId());
            stmt.setInt(3, detalle.getCantidad());
            stmt.setBigDecimal(4, detalle.getPrecioUnitario());
            stmt.setBigDecimal(5, detalle.getSubtotal());
            stmt.setLong(6, detalle.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(Long id) {
        String sql = "DELETE FROM detalle_pedido WHERE id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<DetallePedido> listarTodos() {
        List<DetallePedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM detalle_pedido ORDER BY id DESC";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                DetallePedido d = new DetallePedido(
                    rs.getLong("id"),
                    rs.getLong("pedido_id"),
                    rs.getLong("producto_id"),
                    rs.getInt("cantidad"),
                    rs.getBigDecimal("precio_unitario"),
                    rs.getBigDecimal("subtotal")
                );
                lista.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método extra útil para listar los detalles asociados a un pedido específico
    public List<DetallePedido> listarPorPedido(Long pedidoId) {
        List<DetallePedido> lista = new ArrayList<>();
        String sql = "SELECT * FROM detalle_pedido WHERE pedido_id = ? ORDER BY id ASC";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, pedidoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                DetallePedido d = new DetallePedido(
                    rs.getLong("id"),
                    rs.getLong("pedido_id"),
                    rs.getLong("producto_id"),
                    rs.getInt("cantidad"),
                    rs.getBigDecimal("precio_unitario"),
                    rs.getBigDecimal("subtotal")
                );
                lista.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}