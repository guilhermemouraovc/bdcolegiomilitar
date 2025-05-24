package com.cesarschool.bdcolegiomilitar.dao;

import com.cesarschool.bdcolegiomilitar.model.Clube;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClubeDAO {

    private final JdbcTemplate jdbc;

    public ClubeDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public int insert(Clube c) {
        String sql = """
            INSERT INTO clube (nome, descricao, ativo)
            VALUES (?,?,?)
            """;
        return jdbc.update(sql,
                c.getNome(),
                c.getDescricao(),
                c.getAtivo()
        );
    }

    // READ all
    public List<Clube> findAll() {
        String sql = "SELECT * FROM clube";
        return jdbc.query(sql, (rs, rowNum) -> {
            Clube c = new Clube();
            c.setIdClube(rs.getInt("id_clube"));
            c.setNome(rs.getString("nome"));
            c.setDescricao(rs.getString("descricao"));
            c.setAtivo(rs.getBoolean("ativo"));
            c.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            c.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return c;
        });
    }

    // READ by ID
    public Clube findById(int id) {
        String sql = "SELECT * FROM clube WHERE id_clube = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Clube c = new Clube();
            c.setIdClube(rs.getInt("id_clube"));
            c.setNome(rs.getString("nome"));
            c.setDescricao(rs.getString("descricao"));
            c.setAtivo(rs.getBoolean("ativo"));
            c.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            c.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return c;
        });
    }

    // UPDATE
    public int update(Clube c) {
        String sql = """
            UPDATE clube
            SET nome = ?, descricao = ?, ativo = ?
            WHERE id_clube = ?
            """;
        return jdbc.update(sql,
                c.getNome(),
                c.getDescricao(),
                c.getAtivo(),
                c.getIdClube()
        );
    }

    // DELETE
    public int delete(int id) {
        return jdbc.update("DELETE FROM clube WHERE id_clube = ?", id);
    }
}
