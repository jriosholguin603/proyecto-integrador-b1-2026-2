
package com.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL =
            System.getenv("DB_URL");

    private static final String USUARIO =
            System.getenv("DB_USERNAME");

    private static final String CLAVE =
            System.getenv("DB_PASSWORD");

    public static Connection conectar() throws SQLException {
        if (URL == null || USUARIO == null || CLAVE == null) {
            throw new SQLException(
                    "Faltan las variables de conexión a la base de datos."
            );
        }

        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}
