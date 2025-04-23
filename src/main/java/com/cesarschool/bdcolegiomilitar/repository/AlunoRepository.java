package com.cesarschool.bdcolegiomilitar.repository;

import com.cesarschool.bdcolegiomilitar.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {


    List<Aluno> findByNome(String nome);
}
