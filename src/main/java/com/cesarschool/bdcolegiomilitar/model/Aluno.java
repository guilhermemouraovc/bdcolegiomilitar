package com.cesarschool.bdcolegiomilitar.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAluno;

    private String nome;

    private LocalDate dataNasc;

    private String tamanhoFardamento;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "id_responsavel")
    private Responsavel responsavel;

    public Aluno() {}

    public Aluno(Long idAluno, String nome, LocalDate dataNasc, String tamanhoFardamento, Turma turma, Responsavel responsavel) {
        this.idAluno = idAluno;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.tamanhoFardamento = tamanhoFardamento;
        this.turma = turma;
        this.responsavel = responsavel;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTamanhoFardamento() {
        return tamanhoFardamento;
    }

    public void setTamanhoFardamento(String tamanhoFardamento) {
        this.tamanhoFardamento = tamanhoFardamento;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
}
