package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.config.ConexionBD;
import com.model.Clientes;

public class ClientesDAO {

    public void guardar(Clientes cliente) {
        String sql = "INSERT INTO clientes (nombre, apellido, email, telefono, direccion, estado, fecha_registro) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING id";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getDireccion());
            stmt.setString(6, cliente.getEstado() != null ? cliente.getEstado() : "activo");
            stmt.setTimestamp(7, Timestamp.valueOf(cliente.getFechaRegistro() != null ? cliente.getFechaRegistro() : LocalDateTime.now()));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cliente.setId(rs.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar(Clientes cliente) {
        String sql = "UPDATE clientes SET nombre=?, apellido=?, email=?, telefono=?, direccion=?, estado=? WHERE id=?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getDireccion());
            stmt.setString(6, cliente.getEstado());
            stmt.setLong(7, cliente.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(Long id) {
        String sql = "DELETE FROM clientes WHERE id = ?";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Clientes> listarTodos() {
        List<Clientes> lista = new ArrayList<>();
        String sql = "SELECT * FROM clientes ORDER BY id DESC";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Timestamp ts = rs.getTimestamp("fecha_registro");
                LocalDateTime fecha = (ts != null) ? ts.toLocalDateTime() : null;

                Clientes c = new Clientes(
                    rs.getLong("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getString("telefono"),
                    rs.getString("direccion"),
                    rs.getString("estado"),
                    fecha
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}