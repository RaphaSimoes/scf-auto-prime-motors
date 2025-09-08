package com.auto_prime.demo.repositories;

import com.auto_prime.demo.entities.Funcionario;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FuncionarioRepository extends MongoRepository <Funcionario, String> {

    List<Funcionario> findBySetor(String setor);
    List<Funcionario> findByNomeContaingIgnoreCase(String nome);

}
