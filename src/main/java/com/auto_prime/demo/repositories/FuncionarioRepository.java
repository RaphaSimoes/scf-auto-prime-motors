package com.auto_prime.demo.repositories;

import com.auto_prime.demo.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findBySetor(String setor);
    List<Funcionario> findByNomeContainingIgnoreCase(String nome);

}
