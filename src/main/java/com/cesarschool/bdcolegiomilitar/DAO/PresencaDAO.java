package com.cesarschool.bdcolegiomilitar.dao;

import com.cesarschool.bdcolegiomilitar.model.Presenca;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class PresencaDAO {

    private final JdbcTemplate jdbc;

    public PresencaDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public int insert(Presenca p) {
        String sql = """
            INSERT INTO presenca
              (id_aluno, id_turma, data_aula, presente)
            VALUES (?,?,?,?)
            """;
        return jdbc.update(sql,
                p.getIdAluno(),
                p.getIdTurma(),
                Date.valueOf(p.getDataAula()),
                p.getPresente()
        );
    }

    // READ all
    public List<Presenca> findAll() {
        String sql = "SELECT * FROM presenca";
        return jdbc.query(sql, (rs, rn) -> {
            Presenca p = new Presenca();
            p.setIdPresenca(rs.getInt("id_presenca"));
            p.setIdAluno(rs.getInt("id_aluno"));
            p.setIdTurma(rs.getInt("id_turma"));
            p.setDataAula(rs.getDate("data_aula").toLocalDate());
            p.setPresente(rs.getBoolean("presente"));
            p.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            p.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return p;
        });
    }

    // READ by ID
    public Presenca findById(int id) {
        String sql = "SELECT * FROM presenca WHERE id_presenca = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rn) -> {
            Presenca p = new Presenca();
            p.setIdPresenca(rs.getInt("id_presenca"));
            p.setIdAluno(rs.getInt("id_aluno"));
            p.setIdTurma(rs.getInt("id_turma"));
            p.setDataAula(rs.getDate("data_aula").toLocalDate());
            p.setPresente(rs.getBoolean("presente"));
            p.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            p.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return p;
        });
    }

    // UPDATE
    public int update(Presenca p) {
        String sql = """
            UPDATE presenca
            SET id_aluno=?, id_turma=?, data_aula=?, presente=?
            WHERE id_presenca=?
            """;
        return jdbc.update(sql,
                p.getIdAluno(),
                p.getIdTurma(),
                Date.valueOf(p.getDataAula()),
                p.getPresente(),
                p.getIdPresenca()
        );
    }

    // DELETE
    public int delete(int id) {
        return jdbc.update("DELETE FROM presenca WHERE id_presenca = ?", id);
    }
}
