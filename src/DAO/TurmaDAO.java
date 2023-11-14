package DAO;

import Model.Turma;
import Utils.ConexaoBanco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TurmaDAO {

    public static ArrayList<Turma> buscarTurmasPorProfessor(int idProfessor) {
        ArrayList<Turma> turmas = new ArrayList<>();

        try (PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement("SELECT * FROM turma WHERE id_professor = ?")) {
            statement.setInt(1, idProfessor);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    turmas.add(new Turma(resultSet.getInt("numero"), resultSet.getString("nome")));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Lide com a exceção conforme necessário
        }

        return turmas;
    }

    public static Turma buscarTurmaPorId(int id) {
        try (PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement("SELECT * FROM Turma WHERE numero = ?");) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Turma(resultSet.getInt("numero"), resultSet.getString("nome"));
                }
            }

        } catch (SQLException e) {

        }

        return null; // Retorna null se não encontrar nenhuma turma com o ID especificado
    }

    public static boolean deletarTurma(int id) {
        try (PreparedStatement statement = ConexaoBanco.getConexao().prepareStatement("DELETE FROM Turma WHERE numero = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}
