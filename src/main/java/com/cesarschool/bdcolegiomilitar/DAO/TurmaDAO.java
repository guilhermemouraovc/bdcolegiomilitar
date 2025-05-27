package com.cesarschool.bdcolegiomilitar.dao;

import com.cesarschool.bdcolegiomilitar.model.Turma;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TurmaDAO {

    private final JdbcTemplate jdbc;

    public TurmaDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public int insert(Turma t) {
        String sql = """
            INSERT INTO turma
              (nome_turma, ano_escolar, turno, capacidade, id_diretor, ativo)
            VALUES (?,?,?,?,?,?)
            """;
        return jdbc.update(sql,
                t.getNomeTurma(),
                t.getAnoEscolar(),
                t.getTurno(),
                t.getCapacidade(),
                t.getIdDiretor(),
                t.getAtivo()
        );
    }

    // READ all
    public List<Turma> findAll() {
        String sql = "SELECT * FROM turma";
        return jdbc.query(sql, (rs, rn) -> {
            Turma t = new Turma();
            t.setIdTurma(rs.getInt("id_turma"));
            t.setNomeTurma(rs.getString("nome_turma"));
            t.setAnoEscolar(rs.getString("ano_escolar"));
            t.setTurno(rs.getString("turno"));
            t.setCapacidade(rs.getInt("capacidade"));
            t.setIdDiretor(rs.getInt("id_diretor"));
            t.setAtivo(rs.getBoolean("ativo"));
            t.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            t.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return t;
        });
    }

    // READ by ID
    public Turma findById(int id) {
        String sql = "SELECT * FROM turma WHERE id_turma = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rn) -> {
            Turma t = new Turma();
            t.setIdTurma(rs.getInt("id_turma"));
            t.setNomeTurma(rs.getString("nome_turma"));
            t.setAnoEscolar(rs.getString("ano_escolar"));
            t.setTurno(rs.getString("turno"));
            t.setCapacidade(rs.getInt("capacidade"));
            t.setIdDiretor(rs.getInt("id_diretor"));
            t.setAtivo(rs.getBoolean("ativo"));
            t.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            t.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return t;
        });
    }

    // UPDATE
    public int update(Turma t) {
        String sql = """
            UPDATE turma
            SET nome_turma=?, ano_escolar=?, turno=?, capacidade=?, id_diretor=?, ativo=?
            WHERE id_turma=?
            """;
        return jdbc.update(sql,
                t.getNomeTurma(),
                t.getAnoEscolar(),
                t.getTurno(),
                t.getCapacidade(),
                t.getIdDiretor(),
                t.getAtivo(),
                t.getIdTurma()
        );
    }

    // DELETE
    public int delete(int id) {
        return jdbc.update("DELETE FROM turma WHERE id_turma = ?", id);
    }
}
