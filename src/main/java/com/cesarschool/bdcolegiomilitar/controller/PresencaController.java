package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.dao.PresencaDAO;
import com.cesarschool.bdcolegiomilitar.model.Presenca;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/presencas")
public class PresencaController {

    private final PresencaDAO dao;

    public PresencaController(PresencaDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Presenca> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Presenca getById(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Presenca p) {
        dao.insert(p);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Presenca p) {
        p.setIdPresenca(id);
        dao.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}
