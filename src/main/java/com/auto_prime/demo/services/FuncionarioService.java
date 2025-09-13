package com.auto_prime.demo.services;

import com.auto_prime.demo.dto.FuncionarioDTO;
import com.auto_prime.demo.entities.Funcionario;
import com.auto_prime.demo.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public FuncionarioDTO criarFuncionario(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(dto.getNome());
        funcionario.setGenero(dto.getGenero());
        funcionario.setCpf(dto.getCpf());
        funcionario.setTelefone(dto.getTelefone());
        funcionario.setEndereco(dto.getEndereco());
        funcionario.setCargo(dto.getCargo());
        funcionario.setSetor(dto.getSetor());
        funcionario.setDataAdmissao(dto.getDataAdmissao());
        funcionario.setSalario(dto.getSalario());
        funcionario.setStatus(dto.getStatus()); // ADICIONADO

        Funcionario salvo = repository.save(funcionario);
        return new FuncionarioDTO(salvo);
    }

    public List<FuncionarioDTO> buscarFuncionario() {
        return repository.findAll().stream().map(FuncionarioDTO::new).toList();
    }

    public void deletarFuncionario(Long id) {
        repository.deleteById(id);
    }

    public FuncionarioDTO atualizarFuncionario(Long id, FuncionarioDTO dto) {
        Funcionario entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado com o ID: " + id));

        copyDtoToEntity(dto, entity);

        entity = repository.save(entity);
        return new FuncionarioDTO(entity);
    }
    private void copyDtoToEntity(FuncionarioDTO dto, Funcionario entity) {
        if (dto.getSalario() != null && !dto.getSalario().isBlank()) {
            try {
                // Remove "R$", espaços, e troca a vírgula por ponto
                String salarioLimpo = dto.getSalario()
                        .replaceAll("[^\\d,]", "")
                        .replace(",", ".");
                entity.setSalario(salarioLimpo);
            } catch (NumberFormatException e) {
                entity.setSalario("0.0");
            }
        }

        entity.setNome(dto.getNome());
        entity.setGenero(dto.getGenero());
        entity.setCpf(dto.getCpf());
        entity.setTelefone(dto.getTelefone());
        entity.setEndereco(dto.getEndereco());
        entity.setCargo(dto.getCargo());
        entity.setSetor(dto.getSetor());
        entity.setDataAdmissao(dto.getDataAdmissao());
        entity.setSalario(dto.getSalario());
        entity.setStatus(dto.getStatus());
    }
}