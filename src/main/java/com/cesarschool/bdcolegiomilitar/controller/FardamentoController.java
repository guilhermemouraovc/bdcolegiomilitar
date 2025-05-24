package com.cesarschool.bdcolegiomilitar.controller;


import com.cesarschool.bdcolegiomilitar.DAO.FardamentoDAO;
import com.cesarschool.bdcolegiomilitar.model.Fardamento;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class FardamentoController {
    private FardamentoDAO fardamentoDAO;

    public FardamentoController(Connection conn) {
        this.fardamentoDAO = new FardamentoDAO(conn);
    }

    public void adicionarFardamento(Fardamento f) throws SQLException {
        fardamentoDAO.inserir(f);
    }

    public List<Fardamento> listarFardamentos() throws SQLException {
        return fardamentoDAO.listarTodos();
    }

    public void atualizarFardamento(Fardamento f) throws SQLException {
        fardamentoDAO.atualizar(f);
    }

    public void removerFardamento(int idAluno) throws SQLException {
        fardamentoDAO.deletar(idAluno);
    }
}

