package com.cesarschool.bdcolegiomilitar.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ClubeAluno {
    private Integer idClubeAluno;
    private Integer idAluno;
    private Integer idClube;
    private LocalDate dataIngresso;
    private LocalDate dataSaida;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Integer getIdClubeAluno() { return idClubeAluno; }
    public void setIdClubeAluno(Integer idClubeAluno) { this.idClubeAluno = idClubeAluno; }

    public Integer getIdAluno() { return idAluno; }
    public void setIdAluno(Integer idAluno) { this.idAluno = idAluno; }

    public Integer getIdClube() { return idClube; }
    public void setIdClube(Integer idClube) { this.idClube = idClube; }

    public LocalDate getDataIngresso() { return dataIngresso; }
    public void setDataIngresso(LocalDate dataIngresso) { this.dataIngresso = dataIngresso; }

    public LocalDate getDataSaida() { return dataSaida; }
    public void setDataSaida(LocalDate dataSaida) { this.dataSaida = dataSaida; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(LocalDateTime atualizadoEm) { this.atualizadoEm = atualizadoEm; }
}
