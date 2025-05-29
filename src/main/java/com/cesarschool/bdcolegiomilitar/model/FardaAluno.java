package com.cesarschool.bdcolegiomilitar.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FardaAluno {
    private int idFardaAluno;
    private int idAluno;
    private int idFarda;
    private LocalDate dataEntrega;
    private boolean ativo;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    // objetos associados
    private Aluno aluno;
    private Fardamento fardamento;

    // getters & setters
    public int getIdFardaAluno() { return idFardaAluno; }
    public void setIdFardaAluno(int id) { this.idFardaAluno = id; }

    public int getIdAluno() { return idAluno; }
    public void setIdAluno(int idAluno) { this.idAluno = idAluno; }

    public int getIdFarda() { return idFarda; }
    public void setIdFarda(int idFarda) { this.idFarda = idFarda; }

    public LocalDate getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(LocalDate dataEntrega) { this.dataEntrega = dataEntrega; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(LocalDateTime atualizadoEm) { this.atualizadoEm = atualizadoEm; }

    public Aluno getAluno() { return aluno; }
    public void setAluno(Aluno aluno) { this.aluno = aluno; }

    public Fardamento getFardamento() { return fardamento; }
    public void setFardamento(Fardamento fardamento) { this.fardamento = fardamento; }
}
