package com.cesarschool.bdcolegiomilitar.model;

import jakarta.persistence.*;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTurma;

    private Integer anoEscolar;

    public Turma() {}

    public Turma(Integer idTurma, Integer anoEscolar) {
        this.idTurma = idTurma;
        this.anoEscolar = anoEscolar;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public Integer getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(Integer anoEscolar) {
        this.anoEscolar = anoEscolar;
    }
}
