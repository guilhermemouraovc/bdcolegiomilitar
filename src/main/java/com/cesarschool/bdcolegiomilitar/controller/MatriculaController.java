package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.dao.MatriculaDAO;
import com.cesarschool.bdcolegiomilitar.model.Matricula;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaDAO dao;

    public MatriculaController(MatriculaDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Matricula> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Matricula getById(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Matricula m) {
        dao.insert(m);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Matricula m) {
        m.setIdMatricula(id);
        dao.update(m);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}
