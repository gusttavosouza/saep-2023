package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    public static Connection getConexao() {
        try {
            String url = "jdbc:postgresql://localhost:5432/saep_db";
            String user = "docker";
            String password = "docker";
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Erro na conexão " + e.getMessage());
        }
        return null;
    }

}
