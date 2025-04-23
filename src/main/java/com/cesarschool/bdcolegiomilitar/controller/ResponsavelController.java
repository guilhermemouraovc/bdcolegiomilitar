package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.model.Responsavel;
import com.cesarschool.bdcolegiomilitar.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @GetMapping
    public List<Responsavel> listarTodos() {
        return responsavelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Responsavel buscarPorId(@PathVariable Long id) {
        return responsavelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Responsável não encontrado"));
    }

    @PostMapping
    public Responsavel criar(@RequestBody Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

    @PutMapping("/{id}")
    public Responsavel atualizar(@PathVariable Long id, @RequestBody Responsavel responsavelAtualizado) {
        return responsavelRepository.findById(id).map(responsavel -> {
            responsavel.setNome(responsavelAtualizado.getNome());
            responsavel.setParentesco(responsavelAtualizado.getParentesco());
            responsavel.setTelefone(responsavelAtualizado.getTelefone());
            return responsavelRepository.save(responsavel);
        }).orElseThrow(() -> new RuntimeException("Responsável não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        responsavelRepository.deleteById(id);
    }
}
