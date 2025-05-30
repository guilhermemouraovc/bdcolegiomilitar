package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.dao.DiretorDAO;
import com.cesarschool.bdcolegiomilitar.model.Diretor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private final DiretorDAO dao;

    public DiretorController(DiretorDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Diretor> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Diretor getById(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Diretor d) {
        dao.insert(d);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Diretor d) {
        d.setIdDiretor(id);
        dao.update(d);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}
