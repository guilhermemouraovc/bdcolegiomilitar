package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.dao.AlunoDAO;
import com.cesarschool.bdcolegiomilitar.model.Aluno;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoDAO dao;

    public AlunoController(AlunoDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Aluno> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Aluno getById(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Aluno a) {
        dao.insert(a);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable int id,
            @RequestBody Aluno a
    ) {
        a.setIdAluno(id);
        dao.update(a);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}
