package com.cesarschool.bdcolegiomilitar.dao;

import com.cesarschool.bdcolegiomilitar.model.Matricula;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class MatriculaDAO {

    private final JdbcTemplate jdbc;

    public MatriculaDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public int insert(Matricula m) {
        String sql = """
            INSERT INTO matricula
              (id_aluno, id_turma, ano, data_matricula, status)
            VALUES (?,?,?,?,?)
            """;
        return jdbc.update(sql,
                m.getIdAluno(),
                m.getIdTurma(),
                m.getAno(),
                Date.valueOf(m.getDataMatricula()),
                m.getStatus()
        );
    }

    // READ all
    public List<Matricula> findAll() {
        String sql = "SELECT * FROM matricula";
        return jdbc.query(sql, (rs, rn) -> {
            Matricula m = new Matricula();
            m.setIdMatricula(rs.getInt("id_matricula"));
            m.setIdAluno(rs.getInt("id_aluno"));
            m.setIdTurma(rs.getInt("id_turma"));
            m.setAno(rs.getString("ano"));
            m.setDataMatricula(rs.getDate("data_matricula").toLocalDate());
            m.setStatus(rs.getString("status"));
            m.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            m.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return m;
        });
    }

    // READ by ID
    public Matricula findById(int id) {
        String sql = "SELECT * FROM matricula WHERE id_matricula = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rn) -> {
            Matricula m = new Matricula();
            m.setIdMatricula(rs.getInt("id_matricula"));
            m.setIdAluno(rs.getInt("id_aluno"));
            m.setIdTurma(rs.getInt("id_turma"));
            m.setAno(rs.getString("ano"));
            m.setDataMatricula(rs.getDate("data_matricula").toLocalDate());
            m.setStatus(rs.getString("status"));
            m.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            m.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return m;
        });
    }

    // UPDATE
    public int update(Matricula m) {
        String sql = """
            UPDATE matricula
            SET id_aluno=?, id_turma=?, ano=?, data_matricula=?, status=?
            WHERE id_matricula=?
            """;
        return jdbc.update(sql,
                m.getIdAluno(),
                m.getIdTurma(),
                m.getAno(),
                Date.valueOf(m.getDataMatricula()),
                m.getStatus(),
                m.getIdMatricula()
        );
    }

    // DELETE
    public int delete(int id) {
        return jdbc.update("DELETE FROM matricula WHERE id_matricula = ?", id);
    }
}
