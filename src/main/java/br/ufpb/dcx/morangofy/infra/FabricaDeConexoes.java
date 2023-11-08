package br.ufpb.dcx.morangofy.infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaDeConexoes {

    private FabricaDeConexoes(){}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost/MusicasDB", "postgres", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
