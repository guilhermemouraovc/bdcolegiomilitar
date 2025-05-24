package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.DAO.NotaDAO;
import com.cesarschool.bdcolegiomilitar.config.DatabaseConnection;
import com.cesarschool.bdcolegiomilitar.model.Nota;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaDAO notaDAO;

    public NotaController() {
        try {
            Connection conn = DatabaseConnection.getConnection();
            this.notaDAO = new NotaDAO(conn);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar no banco de dados", e);
        }
    }

    @PostMapping
    public ResponseEntity<String> adicionar(@RequestBody Nota nota) {
        try {
            notaDAO.adicionar(nota);
            return ResponseEntity.status(201).body("Nota cadastrada com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.internalServerError().body("Erro ao adicionar: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Nota>> listar() {
        try {
            List<Nota> notas = notaDAO.listarTodos();
            return ResponseEntity.ok(notas);
        } catch (SQLException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> buscar(@PathVariable Long id) {
        try {
            Nota nota = notaDAO.buscarPorId(id);
            return (nota != null) ? ResponseEntity.ok(nota) : ResponseEntity.notFound().build();
        } catch (SQLException e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody Nota nota) {
        try {
            nota.setIdNota(id);
            notaDAO.atualizar(nota);
            return ResponseEntity.ok("Nota atualizada com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.internalServerError().body("Erro ao atualizar: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        try {
            notaDAO.deletar(id);
            return ResponseEntity.ok("Nota removida com sucesso!");
        } catch (SQLException e) {
            return ResponseEntity.internalServerError().body("Erro ao deletar: " + e.getMessage());
        }
    }
}
