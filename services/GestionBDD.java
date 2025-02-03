package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GestionBDD {
    public static Connection connect() {
        String url = "jdbc:sqlite:etudiants.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connexion réussie !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
