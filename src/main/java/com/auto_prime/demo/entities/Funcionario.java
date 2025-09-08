package com.auto_prime.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

    public Funcionario(String nome, String cpf, String cargo, String setor, Instant dataDeAdmissao, Double salario, String endereço, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.setor = setor;
        this.dataDeAdmissao = dataDeAdmissao;
        this.salario = salario;
        this.endereco = endereço;
        this.telefone = telefone;
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

    public void setEndereco(String endereço) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
