package com.cesarschool.bdcolegiomilitar.model;

import java.time.LocalDateTime;

public class Fardamento {
    private Integer idFarda;
    private String tipo;
    private String tamanho;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Integer getIdFarda() { return idFarda; }
    public void setIdFarda(Integer idFarda) { this.idFarda = idFarda; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getTamanho() { return tamanho; }
    public void setTamanho(String tamanho) { this.tamanho = tamanho; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(LocalDateTime atualizadoEm) { this.atualizadoEm = atualizadoEm; }
}
