package com.cesarschool.bdcolegiomilitar.dao;

import com.cesarschool.bdcolegiomilitar.model.Responsavel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResponsavelDAO {

    private final JdbcTemplate jdbc;

    public ResponsavelDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public int insert(Responsavel r) {
        String sql = """
            INSERT INTO responsavel
              (nome, parentesco, telefone, email, ativo)
            VALUES (?,?,?,?,?)
            """;
        return jdbc.update(sql,
                r.getNome(),
                r.getParentesco(),
                r.getTelefone(),
                r.getEmail(),
                r.getAtivo()
        );
    }

    // READ all
    public List<Responsavel> findAll() {
        String sql = "SELECT * FROM responsavel";
        return jdbc.query(sql, (rs, rn) -> {
            Responsavel r = new Responsavel();
            r.setIdResponsavel(rs.getInt("id_responsavel"));
            r.setNome(rs.getString("nome"));
            r.setParentesco(rs.getString("parentesco"));
            r.setTelefone(rs.getString("telefone"));
            r.setEmail(rs.getString("email"));
            r.setAtivo(rs.getBoolean("ativo"));
            r.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            r.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return r;
        });
    }

    // READ by ID
    public Responsavel findById(int id) {
        String sql = "SELECT * FROM responsavel WHERE id_responsavel = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rn) -> {
            Responsavel r = new Responsavel();
            r.setIdResponsavel(rs.getInt("id_responsavel"));
            r.setNome(rs.getString("nome"));
            r.setParentesco(rs.getString("parentesco"));
            r.setTelefone(rs.getString("telefone"));
            r.setEmail(rs.getString("email"));
            r.setAtivo(rs.getBoolean("ativo"));
            r.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            r.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return r;
        });
    }

    // UPDATE
    public int update(Responsavel r) {
        String sql = """
            UPDATE responsavel
            SET nome=?, parentesco=?, telefone=?, email=?, ativo=?
            WHERE id_responsavel=?
            """;
        return jdbc.update(sql,
                r.getNome(),
                r.getParentesco(),
                r.getTelefone(),
                r.getEmail(),
                r.getAtivo(),
                r.getIdResponsavel()
        );
    }

    // DELETE
    public int delete(int id) {
        return jdbc.update("DELETE FROM responsavel WHERE id_responsavel = ?", id);
    }
}
