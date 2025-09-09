package com.auto_prime.demo.dto;


import com.auto_prime.demo.entities.Funcionario;

import java.time.Instant;

public class FuncionarioDTO {

    private String id;

    private String nome;
    private String cpf;
    private String cargo;
    private String setor;
    private Instant dataDeAdmissao;
    private Double salario;
    private String endereco;
    private String telefone;


    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Funcionario f) {
        this.id = f.getId();
        this.nome = f.getNome();
        this.cpf = f.getCpf();
        this.cargo = f.getCargo();
        this.setor = f.getSetor();
        this.dataDeAdmissao = f.getDataDeAdmissao();
        this.salario = f.getSalario();
        this.endereco = f.getEndereco();
    }


    public FuncionarioDTO(String id, String nome, String cpf, String cargo, String setor, Instant dataDeAdmissao, Double salario, String endereco, String telefone) {
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

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public String getSetor() {
        return setor;
    }

    public Instant getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public Double getSalario() {
        return salario;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public void setDataDeAdmissao(Instant dataDeAdmissao) {
        this.dataDeAdmissao = dataDeAdmissao;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}