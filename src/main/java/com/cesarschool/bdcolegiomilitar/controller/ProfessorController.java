package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.dao.ProfessorDAO;
import com.cesarschool.bdcolegiomilitar.model.Professor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorDAO dao;

    public ProfessorController(ProfessorDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Professor> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Professor getById(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Professor p) {
        dao.insert(p);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Professor p) {
        p.setIdProfessor(id);
        dao.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}
