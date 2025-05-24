package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.dao.ClubeDAO;
import com.cesarschool.bdcolegiomilitar.model.Clube;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubes")
public class ClubeController {

    private final ClubeDAO dao;

    public ClubeController(ClubeDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Clube> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Clube getById(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Clube c) {
        dao.insert(c);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Clube c) {
        c.setIdClube(id);
        dao.update(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}
