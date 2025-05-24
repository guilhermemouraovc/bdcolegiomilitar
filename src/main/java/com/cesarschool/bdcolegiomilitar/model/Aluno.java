package com.cesarschool.bdcolegiomilitar.model;

import java.time.LocalDate;

public class Aluno {
    private Integer idAluno;
    private String nome;
    private LocalDate dataNasc;
    private Character sexo;
    private Integer idTurma;
    private Integer idResponsavel;

    // getters & setters
    public Integer getIdAluno() { return idAluno; }
    public void setIdAluno(Integer idAluno) { this.idAluno = idAluno; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataNasc() { return dataNasc; }
    public void setDataNasc(LocalDate dataNasc) { this.dataNasc = dataNasc; }

    public Character getSexo() { return sexo; }
    public void setSexo(Character sexo) { this.sexo = sexo; }

    public Integer getIdTurma() { return idTurma; }
    public void setIdTurma(Integer idTurma) { this.idTurma = idTurma; }

    public Integer getIdResponsavel() { return idResponsavel; }
    public void setIdResponsavel(Integer idResponsavel) { this.idResponsavel = idResponsavel; }
}
