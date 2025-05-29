package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.dao.FardaAlunoDAO;
import com.cesarschool.bdcolegiomilitar.model.FardaAluno;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/farda-aluno")
public class FardaAlunoController {

    private final FardaAlunoDAO dao;

    public FardaAlunoController(FardaAlunoDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<FardaAluno> listAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public FardaAluno getById(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    public void create(@RequestBody FardaAluno fa) {
        dao.insert(fa);
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable int id,
            @RequestBody FardaAluno fa
    ) {
        fa.setIdFardaAluno(id);
        dao.update(fa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}
