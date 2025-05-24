package com.cesarschool.bdcolegiomilitar.dao;

import com.cesarschool.bdcolegiomilitar.model.ClubeAluno;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class ClubeAlunoDAO {

    private final JdbcTemplate jdbc;

    public ClubeAlunoDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public int insert(ClubeAluno ca) {
        String sql = """
            INSERT INTO clube_aluno
              (id_aluno, id_clube, data_ingresso, data_saida)
            VALUES (?,?,?,?)
            """;
        return jdbc.update(sql,
                ca.getIdAluno(),
                ca.getIdClube(),
                Date.valueOf(ca.getDataIngresso()),
                ca.getDataSaida() != null ? Date.valueOf(ca.getDataSaida()) : null
        );
    }

    // READ all
    public List<ClubeAluno> findAll() {
        String sql = "SELECT * FROM clube_aluno";
        return jdbc.query(sql, (rs, rn) -> {
            ClubeAluno ca = new ClubeAluno();
            ca.setIdClubeAluno(rs.getInt("id_clube_aluno"));
            ca.setIdAluno(rs.getInt("id_aluno"));
            ca.setIdClube(rs.getInt("id_clube"));
            ca.setDataIngresso(rs.getDate("data_ingresso").toLocalDate());
            var ds = rs.getDate("data_saida");
            if (ds != null) ca.setDataSaida(ds.toLocalDate());
            ca.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            ca.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return ca;
        });
    }

    // READ by ID
    public ClubeAluno findById(int id) {
        String sql = "SELECT * FROM clube_aluno WHERE id_clube_aluno = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rn) -> {
            ClubeAluno ca = new ClubeAluno();
            ca.setIdClubeAluno(rs.getInt("id_clube_aluno"));
            ca.setIdAluno(rs.getInt("id_aluno"));
            ca.setIdClube(rs.getInt("id_clube"));
            ca.setDataIngresso(rs.getDate("data_ingresso").toLocalDate());
            var ds = rs.getDate("data_saida");
            if (ds != null) ca.setDataSaida(ds.toLocalDate());
            ca.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            ca.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return ca;
        });
    }

    // UPDATE
    public int update(ClubeAluno ca) {
        String sql = """
            UPDATE clube_aluno
            SET id_aluno=?, id_clube=?, data_ingresso=?, data_saida=?
            WHERE id_clube_aluno=?
            """;
        return jdbc.update(sql,
                ca.getIdAluno(),
                ca.getIdClube(),
                Date.valueOf(ca.getDataIngresso()),
                ca.getDataSaida() != null ? Date.valueOf(ca.getDataSaida()) : null,
                ca.getIdClubeAluno()
        );
    }

    // DELETE
    public int delete(int id) {
        return jdbc.update("DELETE FROM clube_aluno WHERE id_clube_aluno = ?", id);
    }
}
