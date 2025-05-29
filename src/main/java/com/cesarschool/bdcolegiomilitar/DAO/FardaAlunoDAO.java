package com.cesarschool.bdcolegiomilitar.dao;

import com.cesarschool.bdcolegiomilitar.model.Aluno;
import com.cesarschool.bdcolegiomilitar.model.FardaAluno;
import com.cesarschool.bdcolegiomilitar.model.Fardamento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class FardaAlunoDAO {

    private final JdbcTemplate jdbc;

    public FardaAlunoDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public int insert(FardaAluno fa) {
        String sql = """
            INSERT INTO farda_aluno
              (id_aluno, id_farda, data_entrega, ativo)
            VALUES (?,?,?,?)
            """;
        return jdbc.update(sql,
                fa.getIdAluno(),
                fa.getIdFarda(),
                Timestamp.valueOf(fa.getDataEntrega().atStartOfDay()),
                fa.isAtivo()
        );
    }

    // READ all com JOIN para buscar nome do aluno e tipo de farda
    public List<FardaAluno> findAll() {
        String sql = """
            SELECT
              fa.*,
              a.id_aluno    AS a_id,
              a.nome        AS a_nome,
              f.id_farda    AS f_id,
              f.tipo        AS f_tipo,
              f.tamanho     AS f_tamanho
            FROM farda_aluno fa
              JOIN aluno a      ON fa.id_aluno = a.id_aluno
              JOIN fardamento f ON fa.id_farda  = f.id_farda
            """;
        return jdbc.query(sql, (rs, rowNum) -> {
            FardaAluno fa = new FardaAluno();
            fa.setIdFardaAluno(rs.getInt("id_farda_aluno"));
            fa.setIdAluno(rs.getInt("id_aluno"));
            fa.setIdFarda(rs.getInt("id_farda"));
            fa.setDataEntrega(rs.getTimestamp("data_entrega").toLocalDateTime().toLocalDate());
            fa.setAtivo(rs.getBoolean("ativo"));
            fa.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            fa.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());

            // popula Aluno
            Aluno a = new Aluno();
            a.setIdAluno(rs.getInt("a_id"));
            a.setNome(rs.getString("a_nome"));
            fa.setAluno(a);

            // popula Fardamento
            Fardamento f = new Fardamento();
            f.setIdFarda(rs.getInt("f_id"));
            f.setTipo(rs.getString("f_tipo"));
            f.setTamanho(rs.getString("f_tamanho"));
            fa.setFardamento(f);

            return fa;
        });
    }

    // READ by ID
    public FardaAluno findById(int id) {
        String sql = """
            SELECT
              fa.*,
              a.id_aluno    AS a_id,
              a.nome        AS a_nome,
              f.id_farda    AS f_id,
              f.tipo        AS f_tipo,
              f.tamanho     AS f_tamanho
            FROM farda_aluno fa
              JOIN aluno a      ON fa.id_aluno = a.id_aluno
              JOIN fardamento f ON fa.id_farda  = f.id_farda
            WHERE fa.id_farda_aluno = ?
            """;
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            // ... mesmíssima lógica de mapeamento acima ...
            FardaAluno fa = new FardaAluno();
            fa.setIdFardaAluno(rs.getInt("id_farda_aluno"));
            fa.setIdAluno(rs.getInt("id_aluno"));
            fa.setIdFarda(rs.getInt("id_farda"));
            fa.setDataEntrega(rs.getTimestamp("data_entrega").toLocalDateTime().toLocalDate());
            fa.setAtivo(rs.getBoolean("ativo"));
            fa.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            fa.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());

            Aluno a = new Aluno();
            a.setIdAluno(rs.getInt("a_id"));
            a.setNome(rs.getString("a_nome"));
            fa.setAluno(a);

            Fardamento f = new Fardamento();
            f.setIdFarda(rs.getInt("f_id"));
            f.setTipo(rs.getString("f_tipo"));
            f.setTamanho(rs.getString("f_tamanho"));
            fa.setFardamento(f);

            return fa;
        });
    }

    // UPDATE
    public int update(FardaAluno fa) {
        String sql = """
            UPDATE farda_aluno
            SET id_aluno=?, id_farda=?, data_entrega=?, ativo=?
            WHERE id_farda_aluno=?
            """;
        return jdbc.update(sql,
                fa.getIdAluno(),
                fa.getIdFarda(),
                Timestamp.valueOf(fa.getDataEntrega().atStartOfDay()),
                fa.isAtivo(),
                fa.getIdFardaAluno()
        );
    }

    // DELETE
    public int delete(int id) {
        return jdbc.update("DELETE FROM farda_aluno WHERE id_farda_aluno = ?", id);
    }
}
