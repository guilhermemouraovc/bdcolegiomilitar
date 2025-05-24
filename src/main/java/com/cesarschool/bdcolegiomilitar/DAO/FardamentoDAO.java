package com.cesarschool.bdcolegiomilitar.dao;

import com.cesarschool.bdcolegiomilitar.model.Fardamento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FardamentoDAO {

    private final JdbcTemplate jdbc;

    public FardamentoDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public int insert(Fardamento f) {
        String sql = """
            INSERT INTO fardamento (tipo, tamanho)
            VALUES (?,?)
            """;
        return jdbc.update(sql,
                f.getTipo(),
                f.getTamanho()
        );
    }

    // READ all
    public List<Fardamento> findAll() {
        String sql = "SELECT * FROM fardamento";
        return jdbc.query(sql, (rs, rowNum) -> {
            Fardamento f = new Fardamento();
            f.setIdFarda(rs.getInt("id_farda"));
            f.setTipo(rs.getString("tipo"));
            f.setTamanho(rs.getString("tamanho"));
            f.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            f.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return f;
        });
    }

    // READ by ID
    public Fardamento findById(int id) {
        String sql = "SELECT * FROM fardamento WHERE id_farda = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Fardamento f = new Fardamento();
            f.setIdFarda(rs.getInt("id_farda"));
            f.setTipo(rs.getString("tipo"));
            f.setTamanho(rs.getString("tamanho"));
            f.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            f.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return f;
        });
    }

    // UPDATE
    public int update(Fardamento f) {
        String sql = """
            UPDATE fardamento
            SET tipo = ?, tamanho = ?
            WHERE id_farda = ?
            """;
        return jdbc.update(sql,
                f.getTipo(),
                f.getTamanho(),
                f.getIdFarda()
        );
    }

    // DELETE
    public int delete(int id) {
        return jdbc.update("DELETE FROM fardamento WHERE id_farda = ?", id);
    }
}
