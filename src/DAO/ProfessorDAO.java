package DAO;

import Model.Professor;
import Utils.ConexaoBanco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDAO {
    public static Professor BuscarProfessorPorEmail(String email) {
        String sql = "SELECT * FROM professor WHERE email = ?";
        try (PreparedStatement stmt = ConexaoBanco.getConexao().prepareStatement(sql)) {
            stmt.setObject(1, email);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String emailReturn = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                return new Professor(id, nome, emailReturn, senha);
            } else {
                return null;
            }
        } catch (SQLException error) {
            System.out.println(error);
        }
          
        return null;
    }
}
