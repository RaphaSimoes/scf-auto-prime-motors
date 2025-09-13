package com.auto_prime.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    // Getters e Setters para os novos campos
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Corrija o getter e setter da data
    public LocalDate getDataAdmissao() { return dataAdmissao; }
    public void setDataAdmissao(LocalDate dataAdmissao) { this.dataAdmissao = dataAdmissao; }

    // Construtores, outros getters e setters... (mantenha o que já existe)
    public Funcionario() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }
    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }
    public String getSalario() { return salario; }
    public void setSalario(String salario) { this.salario = salario; }
}