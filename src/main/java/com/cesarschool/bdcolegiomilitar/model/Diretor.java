package com.cesarschool.bdcolegiomilitar.model;

public class Diretor {
    private int idDiretor;
    private String nome;
    private String cargoMilitar;
    private String telefone;

    public Diretor() {}

    public Diretor(int idDiretor, String nome, String cargoMilitar, String telefone) {
        this.idDiretor = idDiretor;
        this.nome = nome;
        this.cargoMilitar = cargoMilitar;
        this.telefone = telefone;
    }

    public int getIdDiretor() {
        return idDiretor;
    }

    public void setIdDiretor(int idDiretor) {
        this.idDiretor = idDiretor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargoMilitar() {
        return cargoMilitar;
    }

    public void setCargoMilitar(String cargoMilitar) {
        this.cargoMilitar = cargoMilitar;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}