package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.dao.NotaDAO;
import com.cesarschool.bdcolegiomilitar.model.Nota;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
public class NotaController {

    private final NotaDAO dao;

    public NotaController(NotaDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Nota> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Nota getById(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Nota n) {
        dao.insert(n);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Nota n) {
        n.setIdNota(id);
        dao.update(n);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}
