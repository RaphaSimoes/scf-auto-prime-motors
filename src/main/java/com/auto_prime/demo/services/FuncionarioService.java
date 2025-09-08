package com.auto_prime.demo.services;

import com.auto_prime.demo.entities.Funcionario;
import com.auto_prime.demo.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    private FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository){
        this.repository = repository;
    }

    public List<Funcionario>listarTodos(){
        return repository.findAll();
    }

    public Funcionario buscarPorId(String id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("funcionario nao encontrado"));
    }

    public Funcionario salvar (Funcionario funcionario){
        return repository.save(funcionario);
    }

    public Funcionario atualizar(String id, Funcionario dadosAtualizados) {
        Funcionario funcionario = buscarPorId(id);
        funcionario.setNome(dadosAtualizados.getNome());
        funcionario.setCpf(dadosAtualizados.getCpf());
        funcionario.setCargo(dadosAtualizados.getCargo());
        funcionario.setSetor(dadosAtualizados.getSetor());
        funcionario.setDataDeAdmissao(dadosAtualizados.getDataDeAdmissao());
        funcionario.setSalario(dadosAtualizados.getSalario());
        funcionario.setEndereco(dadosAtualizados.getEndereco());
        funcionario.setTelefone(dadosAtualizados.getTelefone());
        return repository.save(funcionario);
    }

    public void deletar(String id){
        repository.findById(id);
    }

    public List<Funcionario> filtrarPorSetor(String setor){
        return repository.findBySetor(setor);
    }

    public List<Funcionario> filtrarPorNome(String nome){
        return repository.findByNomeContaingIgnoreCase(nome);
    }






}
