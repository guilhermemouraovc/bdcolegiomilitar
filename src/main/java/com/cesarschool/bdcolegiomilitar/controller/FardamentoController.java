package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.dao.FardamentoDAO;
import com.cesarschool.bdcolegiomilitar.model.Fardamento;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fardamentos")
public class FardamentoController {

    private final FardamentoDAO dao;

    public FardamentoController(FardamentoDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<Fardamento> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Fardamento getById(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Fardamento f) {
        dao.insert(f);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Fardamento f) {
        f.setIdFarda(id);
        dao.update(f);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}
