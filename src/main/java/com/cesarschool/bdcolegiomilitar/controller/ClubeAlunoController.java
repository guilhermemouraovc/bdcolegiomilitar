package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.dao.ClubeAlunoDAO;
import com.cesarschool.bdcolegiomilitar.model.ClubeAluno;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clube-aluno")
public class ClubeAlunoController {

    private final ClubeAlunoDAO dao;

    public ClubeAlunoController(ClubeAlunoDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<ClubeAluno> all() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public ClubeAluno one(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ClubeAluno ca) {
        dao.insert(ca);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody ClubeAluno ca) {
        ca.setIdClubeAluno(id);
        dao.update(ca);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}
