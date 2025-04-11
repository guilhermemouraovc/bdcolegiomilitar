package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.DAO.DiretorDAO;
import com.cesarschool.bdcolegiomilitar.model.Diretor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "")
@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private final DiretorDAO dao = new DiretorDAO();

    @PostMapping
    public ResponseEntity<String> adicionar(@RequestBody Diretor diretor) {
        try {
            dao.adicionar(diretor);
            return ResponseEntity.status(201).body("Diretor cadastrado com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.internalServerError().body("Erro: " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> atualizar(@RequestBody Diretor diretor) {
        try {
            if (diretor.getIdDiretor() == 0) {
                return ResponseEntity.badRequest().body("ID do diretor é obrigatório.");
            }
            dao.atualizar(diretor);
            return ResponseEntity.ok("Diretor atualizado com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.internalServerError().body("Erro ao atualizar: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Diretor>> listar() {
        try {
            return ResponseEntity.ok(dao.listarTodos());
        } catch (SQLException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diretor> buscar(@PathVariable int id) {
        try {
            Diretor diretor = dao.buscarPorId(id);
            return (diretor != null) ? ResponseEntity.ok(diretor) : ResponseEntity.notFound().build();
        } catch (SQLException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deletar(@RequestBody Diretor diretor) {
        try {
            if (diretor.getIdDiretor() == 0) {
                return ResponseEntity.badRequest().body("ID do diretor é obrigatório.");
            }
            dao.deletar(diretor.getIdDiretor());
            return ResponseEntity.ok("Diretor removido com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.internalServerError().body("Erro ao excluir: " + e.getMessage());
        }
    }
}