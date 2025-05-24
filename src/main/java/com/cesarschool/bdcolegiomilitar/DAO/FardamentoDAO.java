package com.cesarschool.bdcolegiomilitar.DAO;
import com.cesarschool.bdcolegiomilitar.model.Fardamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FardamentoDAO {
    private Connection conn;

    public FardamentoDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Fardamento fardamento) throws SQLException {
        String sql = "INSERT INTO fardamento (tamanho, id_aluno) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fardamento.getTamanho());
            stmt.setInt(2, fardamento.getIdAluno());
            stmt.executeUpdate();
        }
    }

    public List<Fardamento> listarTodos() throws SQLException {
        List<Fardamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM fardamento";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Fardamento f = new Fardamento(
                        rs.getString("tamanho"),
                        rs.getInt("id_aluno")
                );
                lista.add(f);
            }
        }
        return lista;
    }

    public void atualizar(Fardamento fardamento) throws SQLException {
        String sql = "UPDATE fardamento SET tamanho = ? WHERE id_aluno = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fardamento.getTamanho());
            stmt.setInt(2, fardamento.getIdAluno());
            stmt.executeUpdate();
        }
    }

    public void deletar(int idAluno) throws SQLException {
        String sql = "DELETE FROM fardamento WHERE id_aluno = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAluno);
            stmt.executeUpdate();
        }
    }
}
