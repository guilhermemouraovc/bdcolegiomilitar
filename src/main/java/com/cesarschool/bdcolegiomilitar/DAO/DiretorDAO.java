package com.cesarschool.bdcolegiomilitar.dao;

import com.cesarschool.bdcolegiomilitar.model.Diretor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class DiretorDAO {

    private final JdbcTemplate jdbc;

    public DiretorDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // CREATE
    public int insert(Diretor d) {
        String sql = """
      INSERT INTO diretor
        (nome, cargo_militar, telefone, email, ativo)
      VALUES (?,?,?,?,?)
      """;
        return jdbc.update(sql,
                d.getNome(),
                d.getCargoMilitar(),
                d.getTelefone(),
                d.getEmail(),
                d.getAtivo()
        );
    }

    // READ all
    public List<Diretor> findAll() {
        String sql = """
        SELECT 
            id_diretor AS idDiretor,
            nome,
            cargo_militar AS cargoMilitar,
            telefone,
            email,
            ativo,
            criado_em,
            atualizado_em
        FROM diretor
    """;
        return jdbc.query(sql, (rs, rowNum) -> {
            Diretor d = new Diretor();
            d.setIdDiretor(rs.getInt("idDiretor"));
            d.setNome(rs.getString("nome"));
            d.setCargoMilitar(rs.getString("cargoMilitar"));
            d.setTelefone(rs.getString("telefone"));
            d.setEmail(rs.getString("email"));
            d.setAtivo(rs.getBoolean("ativo"));
            d.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            d.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return d;
        });
    }
    // READ by ID
    public Diretor findById(int id) {
        String sql = "SELECT * FROM diretor WHERE id_diretor = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Diretor d = new Diretor();
            d.setIdDiretor(rs.getInt("id_diretor"));
            d.setNome(rs.getString("nome"));
            d.setCargoMilitar(rs.getString("cargo_militar"));
            d.setTelefone(rs.getString("telefone"));
            d.setEmail(rs.getString("email"));
            d.setAtivo(rs.getBoolean("ativo"));
            d.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
            d.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());
            return d;
        });
    }

    // UPDATE
    public int update(Diretor d) {
        String sql = """
      UPDATE diretor
      SET nome=?, cargo_militar=?, telefone=?, email=?, ativo=?
      WHERE id_diretor=?
      """;
        return jdbc.update(sql,
                d.getNome(),
                d.getCargoMilitar(),
                d.getTelefone(),
                d.getEmail(),
                d.getAtivo(),
                d.getIdDiretor()
        );
    }

    // DELETE
    public int delete(int id) {
        return jdbc.update("DELETE FROM diretor WHERE id_diretor = ?", id);
    }
}
