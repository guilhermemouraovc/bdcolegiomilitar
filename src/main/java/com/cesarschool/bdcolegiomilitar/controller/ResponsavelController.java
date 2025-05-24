package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.model.Responsavel;
import com.cesarschool.bdcolegiomilitar.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {

    @Autowired
    private ResponsavelRepository repository;

    @PostMapping
    public ResponseEntity<String> adicionar(@RequestBody Responsavel responsavel) {
        repository.save(responsavel);
        return ResponseEntity.status(201).body("Responsável cadastrado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody Responsavel responsavel) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        responsavel.setIdResponsavel(id);
        repository.save(responsavel);
        return ResponseEntity.ok("Responsável atualizado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Responsavel>> listar() {
        List<Responsavel> responsaveis = repository.findAll();
        return ResponseEntity.ok(responsaveis);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Responsavel> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(responsavel -> ResponseEntity.ok(responsavel))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.ok("Responsável removido com sucesso!");
    }
}
