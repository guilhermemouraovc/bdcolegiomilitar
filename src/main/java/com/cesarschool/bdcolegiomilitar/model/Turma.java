package com.cesarschool.bdcolegiomilitar.model;

import java.time.LocalDateTime;

public class Turma {
    private Integer idTurma;
    private String nomeTurma;
    private String anoEscolar;
    private String turno;
    private Integer capacidade;
    private Integer idDiretor;
    private Boolean ativo;
    private LocalDateTime criadoEm;
    private LocalDateTime atualizadoEm;

    public Integer getIdTurma() { return idTurma; }
    public void setIdTurma(Integer idTurma) { this.idTurma = idTurma; }

    public String getNomeTurma() { return nomeTurma; }
    public void setNomeTurma(String nomeTurma) { this.nomeTurma = nomeTurma; }

    public String getAnoEscolar() { return anoEscolar; }
    public void setAnoEscolar(String anoEscolar) { this.anoEscolar = anoEscolar; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public Integer getCapacidade() { return capacidade; }
    public void setCapacidade(Integer capacidade) { this.capacidade = capacidade; }

    public Integer getIdDiretor() { return idDiretor; }
    public void setIdDiretor(Integer idDiretor) { this.idDiretor = idDiretor; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }

    public LocalDateTime getCriadoEm() { return criadoEm; }
    public void setCriadoEm(LocalDateTime criadoEm) { this.criadoEm = criadoEm; }

    public LocalDateTime getAtualizadoEm() { return atualizadoEm; }
    public void setAtualizadoEm(LocalDateTime atualizadoEm) { this.atualizadoEm = atualizadoEm; }
}
