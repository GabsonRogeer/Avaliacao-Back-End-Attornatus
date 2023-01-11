package com.testeJava.attornatus.repository;

import com.testeJava.attornatus.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
