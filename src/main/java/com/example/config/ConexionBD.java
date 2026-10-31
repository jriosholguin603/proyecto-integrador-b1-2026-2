package com.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:postgresql://ep-hidden-dawn-a42o28z5-pooler.us-east-1.aws.neon.tech/neondb?sslmode=require";
    private static final String USUARIO = "neondb_owner";
    private static final String CLAVE = "TU_CONTRASEÑA_DE_NEON";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CLAVE);
    }
}