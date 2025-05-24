package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.model.Turma;
import com.cesarschool.bdcolegiomilitar.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @PostMapping
    public ResponseEntity<String> adicionar(@RequestBody Turma turma) {
        repository.save(turma);
        return ResponseEntity.status(201).body("Turma cadastrada com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody Turma turma) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        turma.setIdTurma(id);
        repository.save(turma);
        return ResponseEntity.ok("Turma atualizada com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Turma>> listar() {
        List<Turma> turmas = repository.findAll();
        return ResponseEntity.ok(turmas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(turma -> ResponseEntity.ok(turma))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Turma removida com sucesso!");
    }
}
