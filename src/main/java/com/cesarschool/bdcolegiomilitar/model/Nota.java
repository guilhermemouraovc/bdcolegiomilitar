package com.cesarschool.bdcolegiomilitar.model;

import jakarta.persistence.*;

@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idNota;

    private Integer valor;

    public Nota() {}

    public Nota(Long idNota, Integer valor) {
        this.idNota = idNota;
        this.valor = valor;
    }

    public Long getIdNota() {
        return idNota;
    }

    public void setIdNota(Long idNota) {
        this.idNota = idNota;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }
}
