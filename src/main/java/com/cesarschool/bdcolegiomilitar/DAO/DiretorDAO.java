package com.cesarschool.bdcolegiomilitar.DAO;

import com.cesarschool.bdcolegiomilitar.model.Diretor;
import com.cesarschool.bdcolegiomilitar.config.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DiretorDAO {

    public void adicionar(Diretor diretor) throws SQLException {
        String sql = "INSERT INTO diretor (id_diretor, nome, cargo_militar, telefone) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, diretor.getIdDiretor());
            stmt.setString(2, diretor.getNome());
            stmt.setString(3, diretor.getCargoMilitar());
            stmt.setString(4, diretor.getTelefone());
            stmt.executeUpdate();
        }
    }

    public List<Diretor> listarTodos() throws SQLException {
        List<Diretor> lista = new ArrayList<>();
        String sql = "SELECT * FROM diretor";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Diretor d = new Diretor(
                        rs.getInt("id_diretor"),
                        rs.getString("nome"),
                        rs.getString("cargo_militar"),
                        rs.getString("telefone")
                );
                lista.add(d);
            }
        }
        return lista;
    }

    public Diretor buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM diretor WHERE id_diretor = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Diretor(
                            rs.getInt("id_diretor"),
                            rs.getString("nome"),
                            rs.getString("cargo_militar"),
                            rs.getString("telefone")
                    );
                }
            }
        }
        return null;
    }
    public void atualizar(Diretor diretor) throws SQLException {
        String sql = "UPDATE diretor SET nome = ?, cargo_militar = ?, telefone = ? WHERE id_diretor = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, diretor.getNome());
            stmt.setString(2, diretor.getCargoMilitar());
            stmt.setString(3, diretor.getTelefone());
            stmt.setInt(4, diretor.getIdDiretor());
            stmt.executeUpdate();
        }
    }

    public void deletar(int id) throws SQLException {
        String sql = "DELETE FROM diretor WHERE id_diretor = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}