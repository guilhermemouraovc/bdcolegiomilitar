package com.cesarschool.bdcolegiomilitar.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Presenca {
    private Integer idPresenca;
    private Integer idAluno;
    private Integer idTurma;
    private LocalDate dataAula;
    private Boolean presente;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Integer getIdPresenca() { return idPresenca; }
    public void setIdPresenca(Integer idPresenca) { this.idPresenca = idPresenca; }

    public Integer getIdAluno() { return idAluno; }
    public void setIdAluno(Integer idAluno) { this.idAluno = idAluno; }

    public Integer getIdTurma() { return idTurma; }
    public void setIdTurma(Integer idTurma) { this.idTurma = idTurma; }

    public LocalDate getDataAula() { return dataAula; }
    public void setDataAula(LocalDate dataAula) { this.dataAula = dataAula; }

    public Boolean getPresente() { return presente; }
    public void setPresente(Boolean presente) { this.presente = presente; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(LocalDateTime atualizadoEm) { this.atualizadoEm = atualizadoEm; }
}
