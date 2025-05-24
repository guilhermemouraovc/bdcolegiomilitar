package com.cesarschool.bdcolegiomilitar.dao;

import com.cesarschool.bdcolegiomilitar.model.Disciplina;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DisciplinaDAO {

    private final JdbcTemplate jdbc;

    public DisciplinaDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public int insert(Disciplina d) {
        String sql = """
            INSERT INTO disciplina
              (nome, carga_horaria, descricao, id_clube, ativo)
            VALUES (?,?,?,?,?)
            """;
        return jdbc.update(sql,
                d.getNome(),
                d.getCargaHoraria(),
                d.getDescricao(),
                d.getIdClube(),
                d.getAtivo()
        );
    }

    // READ all
    public List<Disciplina> findAll() {
        String sql = "SELECT * FROM disciplina";
        return jdbc.query(sql, (rs, rowNum) -> {
            Disciplina d = new Disciplina();
            d.setIdDisciplina(rs.getInt("id_disciplina"));
            d.setNome(rs.getString("nome"));
            d.setCargaHoraria(rs.getInt("carga_horaria"));
            d.setDescricao(rs.getString("descricao"));
            d.setIdClube(rs.getObject("id_clube", Integer.class)); // pode ser null
            d.setAtivo(rs.getBoolean("ativo"));
            d.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            d.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return d;
        });
    }

    // READ by ID
    public Disciplina findById(int id) {
        String sql = "SELECT * FROM disciplina WHERE id_disciplina = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Disciplina d = new Disciplina();
            d.setIdDisciplina(rs.getInt("id_disciplina"));
            d.setNome(rs.getString("nome"));
            d.setCargaHoraria(rs.getInt("carga_horaria"));
            d.setDescricao(rs.getString("descricao"));
            d.setIdClube(rs.getObject("id_clube", Integer.class));
            d.setAtivo(rs.getBoolean("ativo"));
            d.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            d.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return d;
        });
    }

    // UPDATE
    public int update(Disciplina d) {
        String sql = """
            UPDATE disciplina
            SET nome=?, carga_horaria=?, descricao=?, id_clube=?, ativo=?
            WHERE id_disciplina=?
            """;
        return jdbc.update(sql,
                d.getNome(),
                d.getCargaHoraria(),
                d.getDescricao(),
                d.getIdClube(),
                d.getAtivo(),
                d.getIdDisciplina()
        );
    }

    // DELETE
    public int delete(int id) {
        return jdbc.update("DELETE FROM disciplina WHERE id_disciplina = ?", id);
    }
}
