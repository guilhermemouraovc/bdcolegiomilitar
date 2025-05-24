package com.cesarschool.bdcolegiomilitar.dao;

import com.cesarschool.bdcolegiomilitar.model.Aluno;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class AlunoDAO {

    private final JdbcTemplate jdbc;

    public AlunoDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public int insert(Aluno a) {
        String sql = """
      INSERT INTO aluno (
        nome, data_nasc, sexo, id_turma, id_responsavel
      ) VALUES (?,?,?,?,?)
      """;
        return jdbc.update(sql,
                a.getNome(),
                Date.valueOf(a.getDataNasc()),
                String.valueOf(a.getSexo()),
                a.getIdTurma(),
                a.getIdResponsavel()
        );
    }

    // READ all
    public List<Aluno> findAll() {
        String sql = "SELECT * FROM aluno";
        return jdbc.query(sql, (rs, rowNum) -> {
            Aluno a = new Aluno();
            a.setIdAluno(rs.getInt("id_aluno"));
            a.setNome(rs.getString("nome"));
            a.setDataNasc(rs.getDate("data_nasc").toLocalDate());
            a.setSexo(rs.getString("sexo").charAt(0));
            a.setIdTurma(rs.getInt("id_turma"));
            a.setIdResponsavel(rs.getInt("id_responsavel"));
            return a;
        });
    }

    // READ by ID
    public Aluno findById(int id) {
        String sql = "SELECT * FROM aluno WHERE id_aluno = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Aluno a = new Aluno();
            a.setIdAluno(rs.getInt("id_aluno"));
            a.setNome(rs.getString("nome"));
            a.setDataNasc(rs.getDate("data_nasc").toLocalDate());
            a.setSexo(rs.getString("sexo").charAt(0));
            a.setIdTurma(rs.getInt("id_turma"));
            a.setIdResponsavel(rs.getInt("id_responsavel"));
            return a;
        });
    }

    // UPDATE
    public int update(Aluno a) {
        String sql = """
      UPDATE aluno
      SET nome=?, data_nasc=?, sexo=?, id_turma=?, id_responsavel=?
      WHERE id_aluno=?
      """;
        return jdbc.update(sql,
                a.getNome(),
                Date.valueOf(a.getDataNasc()),
                String.valueOf(a.getSexo()),
                a.getIdTurma(),
                a.getIdResponsavel(),
                a.getIdAluno()
        );
    }

    // DELETE
    public int delete(int id) {
        String sql = "DELETE FROM aluno WHERE id_aluno = ?";
        return jdbc.update(sql, id);
    }
}
