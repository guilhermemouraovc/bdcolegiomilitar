package com.cesarschool.bdcolegiomilitar.dao;

import com.cesarschool.bdcolegiomilitar.model.Professor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProfessorDAO {

    private final JdbcTemplate jdbc;

    public ProfessorDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public int insert(Professor p) {
        String sql = """
            INSERT INTO professor
              (nome, especialidade, telefone, email, id_turma_resp, ativo)
            VALUES (?,?,?,?,?,?)
            """;
        return jdbc.update(sql,
                p.getNome(),
                p.getEspecialidade(),
                p.getTelefone(),
                p.getEmail(),
                p.getIdTurmaResp(),
                p.getAtivo()
        );
    }

    // READ all
    public List<Professor> findAll() {
        String sql = "SELECT * FROM professor";
        return jdbc.query(sql, (rs, rn) -> {
            Professor p = new Professor();
            p.setIdProfessor(rs.getInt("id_professor"));
            p.setNome(rs.getString("nome"));
            p.setEspecialidade(rs.getString("especialidade"));
            p.setTelefone(rs.getString("telefone"));
            p.setEmail(rs.getString("email"));
            p.setIdTurmaResp(rs.getObject("id_turma_resp", Integer.class));
            p.setAtivo(rs.getBoolean("ativo"));
            p.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            p.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return p;
        });
    }

    // READ by ID
    public Professor findById(int id) {
        String sql = "SELECT * FROM professor WHERE id_professor = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rn) -> {
            Professor p = new Professor();
            p.setIdProfessor(rs.getInt("id_professor"));
            p.setNome(rs.getString("nome"));
            p.setEspecialidade(rs.getString("especialidade"));
            p.setTelefone(rs.getString("telefone"));
            p.setEmail(rs.getString("email"));
            p.setIdTurmaResp(rs.getObject("id_turma_resp", Integer.class));
            p.setAtivo(rs.getBoolean("ativo"));
            p.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            p.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return p;
        });
    }

    // UPDATE
    public int update(Professor p) {
        String sql = """
            UPDATE professor
            SET nome=?, especialidade=?, telefone=?, email=?, id_turma_resp=?, ativo=?
            WHERE id_professor=?
            """;
        return jdbc.update(sql,
                p.getNome(),
                p.getEspecialidade(),
                p.getTelefone(),
                p.getEmail(),
                p.getIdTurmaResp(),
                p.getAtivo(),
                p.getIdProfessor()
        );
    }

    // DELETE
    public int delete(int id) {
        return jdbc.update("DELETE FROM professor WHERE id_professor = ?", id);
    }
}
