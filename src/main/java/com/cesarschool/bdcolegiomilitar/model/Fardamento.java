package com.cesarschool.bdcolegiomilitar.model;

public class Fardamento {
    private String tamanho;
    private int idAluno;

    public Fardamento() {}

    public Fardamento(String tamanho, int idAluno) {
        this.tamanho = tamanho;
        this.idAluno = idAluno;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
}
