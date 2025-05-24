package com.cesarschool.bdcolegiomilitar.controller;

import com.cesarschool.bdcolegiomilitar.dao.LancamentoNotaDAO;
import com.cesarschool.bdcolegiomilitar.model.LancamentoNota;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentos-nota")
public class LancamentoNotaController {

    private final LancamentoNotaDAO dao;

    public LancamentoNotaController(LancamentoNotaDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public List<LancamentoNota> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public LancamentoNota getById(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody LancamentoNota ln) {
        dao.insert(ln);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody LancamentoNota ln) {
        ln.setIdLanc(id);
        dao.update(ln);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }
}
