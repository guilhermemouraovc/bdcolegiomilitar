package com.cesarschool.bdcolegiomilitar.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LancamentoNota {
    private Integer idLanc;
    private Integer idAluno;
    private Integer idDisciplina;
    private Integer idNota;
    private Double valor;
    private LocalDate dataLanc;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Integer getIdLanc() { return idLanc; }
    public void setIdLanc(Integer idLanc) { this.idLanc = idLanc; }

    public Integer getIdAluno() { return idAluno; }
    public void setIdAluno(Integer idAluno) { this.idAluno = idAluno; }

    public Integer getIdDisciplina() { return idDisciplina; }
    public void setIdDisciplina(Integer idDisciplina) { this.idDisciplina = idDisciplina; }

    public Integer getIdNota() { return idNota; }
    public void setIdNota(Integer idNota) { this.idNota = idNota; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public LocalDate getDataLanc() { return dataLanc; }
    public void setDataLanc(LocalDate dataLanc) { this.dataLanc = dataLanc; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(LocalDateTime atualizadoEm) { this.atualizadoEm = atualizadoEm; }
}
