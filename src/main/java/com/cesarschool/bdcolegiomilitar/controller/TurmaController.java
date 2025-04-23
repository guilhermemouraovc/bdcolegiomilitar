package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.DAO.TurmaDAO;
import com.cesarschool.bdcolegiomilitar.model.Turma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/turmas")
@CrossOrigin(origins = "*")
public class TurmaController {

    private TurmaDAO turmaDAO;

    @Autowired
    public TurmaController(DataSource dataSource) throws SQLException {
        Connection conn = dataSource.getConnection();
        this.turmaDAO = new TurmaDAO(conn);
    }

    @PostMapping
    public void adicionarTurma(@RequestBody Turma turma) throws SQLException {
        turmaDAO.inserir(turma);
    }

    @GetMapping
    public List<Turma> listarTurmas() throws SQLException {
        return turmaDAO.listarTodos();
    }

    @PutMapping("/{id}")
    public void atualizarTurma(@PathVariable int id, @RequestBody Turma turma) throws SQLException {
        turma.setIdTurma(id); // garante que o ID vindo da URL seja usado
        turmaDAO.atualizar(turma);
    }

    @DeleteMapping("/{id}")
    public void removerTurma(@PathVariable int id) throws SQLException {
        turmaDAO.deletar(id);
    }
}
