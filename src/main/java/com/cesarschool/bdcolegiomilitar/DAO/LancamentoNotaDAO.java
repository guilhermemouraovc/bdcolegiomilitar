package com.cesarschool.bdcolegiomilitar.dao;

import com.cesarschool.bdcolegiomilitar.model.LancamentoNota;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class LancamentoNotaDAO {

    private final JdbcTemplate jdbc;

    public LancamentoNotaDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public int insert(LancamentoNota ln) {
        String sql = """
            INSERT INTO lancamento_nota
              (id_aluno, id_disciplina, id_nota, valor, data_lanc)
            VALUES (?,?,?,?,?)
            """;
        return jdbc.update(sql,
                ln.getIdAluno(),
                ln.getIdDisciplina(),
                ln.getIdNota(),
                ln.getValor(),
                Date.valueOf(ln.getDataLanc())
        );
    }

    // READ all
    public List<LancamentoNota> findAll() {
        String sql = "SELECT * FROM lancamento_nota";
        return jdbc.query(sql, (rs, rowNum) -> {
            LancamentoNota ln = new LancamentoNota();
            ln.setIdLanc(rs.getInt("id_lanc"));
            ln.setIdAluno(rs.getInt("id_aluno"));
            ln.setIdDisciplina(rs.getInt("id_disciplina"));
            ln.setIdNota(rs.getInt("id_nota"));
            ln.setValor(rs.getDouble("valor"));
            ln.setDataLanc(rs.getDate("data_lanc").toLocalDate());
            ln.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            ln.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return ln;
        });
    }

    // READ by ID
    public LancamentoNota findById(int id) {
        String sql = "SELECT * FROM lancamento_nota WHERE id_lanc = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            LancamentoNota ln = new LancamentoNota();
            ln.setIdLanc(rs.getInt("id_lanc"));
            ln.setIdAluno(rs.getInt("id_aluno"));
            ln.setIdDisciplina(rs.getInt("id_disciplina"));
            ln.setIdNota(rs.getInt("id_nota"));
            ln.setValor(rs.getDouble("valor"));
            ln.setDataLanc(rs.getDate("data_lanc").toLocalDate());
            ln.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            ln.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return ln;
        });
    }

    // UPDATE
    public int update(LancamentoNota ln) {
        String sql = """
            UPDATE lancamento_nota
            SET id_aluno = ?, id_disciplina = ?, id_nota = ?, valor = ?, data_lanc = ?
            WHERE id_lanc = ?
            """;
        return jdbc.update(sql,
                ln.getIdAluno(),
                ln.getIdDisciplina(),
                ln.getIdNota(),
                ln.getValor(),
                Date.valueOf(ln.getDataLanc()),
                ln.getIdLanc()
        );
    }

    // DELETE
    public int delete(int id) {
        return jdbc.update("DELETE FROM lancamento_nota WHERE id_lanc = ?", id);
    }
}
