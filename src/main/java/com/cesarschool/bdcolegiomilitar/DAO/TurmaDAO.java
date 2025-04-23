package com.cesarschool.bdcolegiomilitar.DAO;

import com.cesarschool.bdcolegiomilitar.model.Turma;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {
    private Connection conn;

    public TurmaDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Turma turma) throws SQLException {
        String sql = "INSERT INTO turma (id_turma, ano_escolar) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, turma.getIdTurma());
            stmt.setInt(2, turma.getAnoEscolar());
            stmt.executeUpdate();
        }
    }

    public List<Turma> listarTodos() throws SQLException {
        List<Turma> lista = new ArrayList<>();
        String sql = "SELECT * FROM turma";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Turma t = new Turma(
                        rs.getInt("id_turma"),
                        rs.getInt("ano_escolar")
                );
                lista.add(t);
            }
        }
        return lista;
    }

    public void atualizar(Turma turma) throws SQLException {
        String sql = "UPDATE turma SET ano_escolar = ? WHERE id_turma = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, turma.getAnoEscolar());
            stmt.setInt(2, turma.getIdTurma());
            stmt.executeUpdate();
        }
    }

    public void deletar(int idTurma) throws SQLException {
        String sql = "DELETE FROM turma WHERE id_turma = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idTurma);
            stmt.executeUpdate();
        }
    }
}
