package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.dao.TurmaDAO;
import com.cesarschool.bdcolegiomilitar.model.Turma;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaDAO dao;

    public TurmaController(TurmaDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Turma> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Turma getById(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Turma t) {
        dao.insert(t);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Turma t) {
        t.setIdTurma(id);
        dao.update(t);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}
