package com.cesarschool.bdcolegiomilitar.model;

import jakarta.persistence.*;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTurma;

    private String anoEscolar;

    public Turma() {}

    public Turma(Long idTurma, String anoEscolar) {
        this.idTurma = idTurma;
        this.anoEscolar = anoEscolar;
    }

    public Long getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Long idTurma) {
        this.idTurma = idTurma;
    }

    public String getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(String anoEscolar) {
        this.anoEscolar = anoEscolar;
    }
}
