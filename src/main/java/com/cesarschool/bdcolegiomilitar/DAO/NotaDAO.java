package com.cesarschool.bdcolegiomilitar.dao;

import com.cesarschool.bdcolegiomilitar.model.Nota;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotaDAO {

    private final JdbcTemplate jdbc;

    public NotaDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public int insert(Nota n) {
        String sql = """
            INSERT INTO nota (descricao, peso)
            VALUES (?,?)
            """;
        return jdbc.update(sql,
                n.getDescricao(),
                n.getPeso()
        );
    }

    // READ all
    public List<Nota> findAll() {
        return jdbc.query("SELECT * FROM nota", (rs, rowNum) -> {
            Nota n = new Nota();
            n.setIdNota(rs.getInt("id_nota"));
            n.setDescricao(rs.getString("descricao"));
            n.setPeso(rs.getDouble("peso"));
            n.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            n.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return n;
        });
    }

    // READ by ID
    public Nota findById(int id) {
        String sql = "SELECT * FROM nota WHERE id_nota = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Nota n = new Nota();
            n.setIdNota(rs.getInt("id_nota"));
            n.setDescricao(rs.getString("descricao"));
            n.setPeso(rs.getDouble("peso"));
            n.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            n.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return n;
        });
    }

    // UPDATE
    public int update(Nota n) {
        String sql = """
            UPDATE nota
            SET descricao = ?, peso = ?
            WHERE id_nota = ?
            """;
        return jdbc.update(sql,
                n.getDescricao(),
                n.getPeso(),
                n.getIdNota()
        );
    }

    // DELETE
    public int delete(int id) {
        return jdbc.update("DELETE FROM nota WHERE id_nota = ?", id);
    }
}
