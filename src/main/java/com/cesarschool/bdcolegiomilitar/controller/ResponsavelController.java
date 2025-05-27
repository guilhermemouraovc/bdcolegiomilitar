package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.dao.ResponsavelDAO;
import com.cesarschool.bdcolegiomilitar.model.Responsavel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsaveis")
public class ResponsavelController {

    private final ResponsavelDAO dao;

    public ResponsavelController(ResponsavelDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Responsavel> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Responsavel getById(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Responsavel r) {
        dao.insert(r);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Responsavel r) {
        r.setIdResponsavel(id);
        dao.update(r);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}
