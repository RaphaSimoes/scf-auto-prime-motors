package com.auto_prime.demo.entities;

import com.auto_prime.demo.dto.FuncionarioDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.auto_prime.demo.dto.FuncionarioDTO;

import java.time.Instant;

@Document(collection = "funcionario")
public class Funcionario {

    @Id
    private String id;

    private String nome;
    private String cpf;
    private String cargo;
    private String setor;
    private Instant dataDeAdmissao;
    private Double salario;
    private String endereco;
    private String telefone;

    public Funcionario(){
    }

    public void atualizarComDTO(FuncionarioDTO dto) {
        this.setNome(dto.getNome());
        this.setCpf(dto.getCpf());
        this.setCargo(dto.getCargo());
        this.setSetor(dto.getSetor());
        this.setDataDeAdmissao(dto.getDataDeAdmissao());
        this.setSalario(dto.getSalario());
        this.setEndereco(dto.getEndereco());
        this.setTelefone(dto.getTelefone());
    }


    public Funcionario(FuncionarioDTO dto) {
        this.nome = dto.getNome();
        this.cpf = dto.getCpf();
        this.cargo = dto.getCargo();
        this.setor = dto.getSetor();
        this.dataDeAdmissao = dto.getDataDeAdmissao();
        this.salario = dto.getSalario();
        this.endereco = dto.getEndereco();
        this.telefone = dto.getTelefone();
    }

    public Funcionario(String id, String nome, String cpf, String cargo, String setor, Instant dataDeAdmissao, Double salario, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.setor = setor;
        this.dataDeAdmissao = dataDeAdmissao;
        this.salario = salario;
        this.endereco = endereco;
        this.telefone = telefone;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Instant getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public void setDataDeAdmissao(Instant dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


}

