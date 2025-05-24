package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.dao.DisciplinaDAO;
import com.cesarschool.bdcolegiomilitar.model.Disciplina;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private final DisciplinaDAO dao;

    public DisciplinaController(DisciplinaDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Disciplina> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Disciplina getById(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Disciplina d) {
        dao.insert(d);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Disciplina d) {
        d.setIdDisciplina(id);
        dao.update(d);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}
