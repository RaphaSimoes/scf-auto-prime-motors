package com.auto_prime.demo.dto;

import com.auto_prime.demo.entities.Funcionario;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FuncionarioDTO {

    private Long id;
    private String nome;
    private String genero;
    private String cpf;
    private String telefone;
    private String endereco;
    private String cargo;
    private String setor;
    private LocalDate dataAdmissao;
    private String salario;
    private String status;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Funcionario f) {
        this.id = f.getId();
        this.nome = f.getNome();
        this.genero = f.getGenero();
        this.cpf = f.getCpf();
        this.telefone = f.getTelefone();
        this.endereco = f.getEndereco();
        this.cargo = f.getCargo();
        this.setor = f.getSetor();
        this.dataAdmissao = f.getDataAdmissao();
        this.salario = f.getSalario();
        this.status = f.getStatus();
    }

}