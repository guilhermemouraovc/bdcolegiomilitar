package com.cesarschool.bdcolegiomilitar.model;

import jakarta.persistence.*;

@Entity
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponsavel;

    private String nome;

    private String parentesco;

    private String telefone;

    public Responsavel() {}

    public Responsavel(Long idResponsavel, String nome, String parentesco, String telefone) {
        this.idResponsavel = idResponsavel;
        this.nome = nome;
        this.parentesco = parentesco;
        this.telefone = telefone;
    }

    public Long getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Long idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
