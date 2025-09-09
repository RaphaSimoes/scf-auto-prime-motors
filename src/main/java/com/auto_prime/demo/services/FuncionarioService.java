package com.auto_prime.demo.services;


import com.auto_prime.demo.dto.FuncionarioDTO;
import com.auto_prime.demo.entities.Funcionario;
import com.auto_prime.demo.exceptions.ResourceNotFoundException;
import com.auto_prime.demo.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    // 1. Criar um novo funcionário
    public FuncionarioDTO criarFuncionario(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());
        funcionario.setCargo(dto.getCargo());
        funcionario.setSetor(dto.getSetor());
        funcionario.setDataDeAdmissao(dto.getDataDeAdmissao());
        funcionario.setSalario(dto.getSalario());
        funcionario.setEndereco(dto.getEndereco());
        funcionario.setTelefone(dto.getTelefone());

        Funcionario salvo = repository.save(funcionario);
        return new FuncionarioDTO(salvo);
    }

    // 2. Listar todos os funcionários
    public List<FuncionarioDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(FuncionarioDTO::new)
                .toList();
    }

    // 3. Buscar funcionário por ID
    public FuncionarioDTO buscarPorId(String id) {
        Funcionario f = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));
        return new FuncionarioDTO(f);
    }

    // 4. Atualizar funcionário existente
    public FuncionarioDTO atualizarFuncionario(String id, FuncionarioDTO dto) {
        Funcionario funcionario = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));

        funcionario.setNome(dto.getNome());
        funcionario.setCpf(dto.getCpf());
        funcionario.setCargo(dto.getCargo());
        funcionario.setSetor(dto.getSetor());
        funcionario.setDataDeAdmissao(dto.getDataDeAdmissao());
        funcionario.setSalario(dto.getSalario());
        funcionario.setEndereco(dto.getEndereco());
        funcionario.setTelefone(dto.getTelefone());

        Funcionario atualizado = repository.save(funcionario);
        return new FuncionarioDTO(atualizado);
    }

    // 5. Deletar funcionário por ID
    public void deletarFuncionario(String id) {
        Funcionario f = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));
        repository.delete(f);
    }
}
