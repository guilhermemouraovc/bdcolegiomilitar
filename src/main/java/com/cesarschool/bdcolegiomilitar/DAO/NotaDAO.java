package com.cesarschool.bdcolegiomilitar.DAO;

import com.cesarschool.bdcolegiomilitar.model.Nota;
import com.cesarschool.bdcolegiomilitar.config.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotaDAO {
    private final Connection conn;

    public NotaDAO(Connection conn) {
        this.conn = conn;
    }

    public void adicionar(Nota nota) throws SQLException {
        String sql = "INSERT INTO nota (id_nota, valor) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, nota.getIdNota()); // agora aceita o ID que você mandar!
            stmt.setInt(2, nota.getValor());
            stmt.executeUpdate();
        }
    }

    public List<Nota> listarTodos() throws SQLException {
        List<Nota> notas = new ArrayList<>();
        String sql = "SELECT * FROM nota";
        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Nota nota = new Nota();
                nota.setIdNota(rs.getLong("id_nota"));
                nota.setValor(rs.getInt("valor"));
                notas.add(nota);
            }
        }
        return notas;
    }

    public Nota buscarPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM nota WHERE id_nota = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Nota nota = new Nota();
                    nota.setIdNota(rs.getLong("id_nota"));
                    nota.setValor(rs.getInt("valor"));
                    return nota;
                }
            }
        }
        return null;
    }

    public void atualizar(Nota nota) throws SQLException {
        String sql = "UPDATE nota SET valor = ? WHERE id_nota = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, nota.getValor());
            stmt.setLong(2, nota.getIdNota());
            stmt.executeUpdate();
        }
    }

    public void deletar(Long id) throws SQLException {
        String sql = "DELETE FROM nota WHERE id_nota = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
